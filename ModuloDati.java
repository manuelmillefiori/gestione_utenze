import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ModuloDati {
    
    // Istanza per la gestione dei file
    private GestioneFile gf;

    //creo una list di map, che contengono le informazioni degli utenti
    private List<Map<String, String>> utenti = new ArrayList<>();

    /**
     * Costruttore per istanziare i vari handle
     */
    public ModuloDati () {

        // Istanza per gestire i dati su file
        gf = new GestioneFile();

        // Aggiorno gli utenti dal file
        utenti = gf.ottieniUtenti();
    }

    //metodo registrazione che mi controlla se l'utente esiste già, e se non esiste me lo crea
    public void registrazione(String username, String password){
        
        //creo una map temporanea a cui poi assegno i valori che mi sono stati dati 
        Map<String, String> utenteT = new HashMap<>(); 
        utenteT.put("username", username);
        utenteT.put("password", sha256Hash(password));

        //inizializzo una variabile booleana a false
        boolean ok=false;

        //scorro tutti gli utenti e controllo se contengono l'username che ho dato a questo metodo
        for(int i=0; i<utenti.size(); i++) {

            if (utenti.get(i).get("username").equals(username)) {

                //se effettivamente l'utente già c'è all'interno della nostra list allora inizializzo ok a true
                ok=true;
                break; 
            }
        }
        
        //controllo dell'ok e messaggi di output
        if(ok){
            //messaggio di output nel caso in cui l'username è stato già registrato in precedenza
            System.out.println("Nome utente gia in uso");
        }else{
            //nel caso in cui non è stato già registrato lo creo dandogli l'username e la password, ma mettendo gli altri campi vuoti
            utenteT.put("username", username);
            utenteT.put("password", sha256Hash(password));
            utenteT.put("nome", "");
            utenteT.put("cognome", "");
            utenteT.put("email", "");
            utenti.add(utenteT);

            //messaggio di output che mi conferma che l'utente è stato creato
            System.out.println("UTENTE CREATO");

            // Creo l'utente su file
            gf.registraUtente(utenteT);
        }
    }

    
    //funzione che mi ritorna un valore true se il login si può effettuare e false se non si può effettuare
    public boolean login(String username, String password){
        //inizializzo una variabile booleana da returnare al main, e che modifico nei vari controlli
        boolean ok=false;

        //Scorro tutta la list di utenti
        for(int i=0; i<utenti.size(); i++){
            
            //se la list non è vuota ma presenta già degli utenti allora mi entra nel codice
            if(utenti.size()!=0){

                //controllo se l'username inserito c'è nella list
                if (utenti.get(i).get("username").equals(username)) {

                    //controllo se la password che mi è arrivata è quella registrata per l'username che mi è arrivato
                    if(utenti.get(i).get("password").equals(sha256Hash(password))) {

                        //se tutte le condizioni sono vere allora mi inizializza la variabile ok a true
                        ok=true;
                        break;
                    } 
                }else{

                    //se queste condizioni non sono vere allora il LogIn non si può effettuare
                    ok=false;
                }   
            }
        }   
        //ritorno la variabile ok
        return ok;
    }


    public Map<String, String> visualizzaInformazioni(String username) {
        
        //inizializzo una map da returnare con i valori che mi servono a null
        Map<String, String> finalvalue = null;

        for(int i = 0; i < utenti.size(); i++) {
            
            //controllo che all'interno della lista c'è l'utente che io sto cercando
            if (utenti.get(i).get("username").equals(username)) {
                
                //se l'utente già esiste inizializzo la map temporanea con le informazioni che devo stampare nel main
                finalvalue=utenti.get(i);
                break;
            }
        }

        //se non ho trovato l'utente mi ritorna di default una map null
        return finalvalue;
    }

    public boolean modificaInformazioni(String username, Map<String, String> mappa) {
    
        //scorro la lista
        for(int i=0; i<utenti.size(); i++) {
            //controllo che all'interno della lista c'è l'utente che io sto cercando
            if (utenti.get(i).get("username").equals(username)) {

                //se lo username non è null mi modifica lo username
                if(mappa.get("username") != null && !(mappa.get("username").equals(""))){
                    utenti.get(i).put("username", mappa.get("username"));
                }

                //se la password non è null mi modifica la password
                if(mappa.get("password") != null && !(mappa.get("password").equals(""))){
                    utenti.get(i).put("password", mappa.get("password"));
                }

                //se il nome non è null mi modifica il nome
                if(mappa.get("nome") != null && !(mappa.get("nome").equals(""))){
                    utenti.get(i).put("nome", mappa.get("nome"));
                }

                //se il cognome non è null mi modifica il cognome
                if(mappa.get("cognome") != null && !(mappa.get("cognome").equals(""))){
                    utenti.get(i).put("cognome", mappa.get("cognome"));
                }

                //se l'email non è null mi modifica l'email
                if(mappa.get("email") != null && !(mappa.get("email").equals(""))){
                    utenti.get(i).put("email", mappa.get("email"));
                }
            }
        }
        
        // Aggiorno i dati dell'utente su file
        return gf.modificaUtente(username, mappa);
    }


    public boolean modificaPassword(String username, String passwordVecchia, String passwordNuova){
        
        boolean ok = false;

        //scorro la lista
        for(int i = 0; i < utenti.size(); i++) {

            //controllo che all'interno della lista c'è l'utente che io sto cercando
            if (utenti.get(i).get("username").equals(username) && utenti.get(i).get("password").equals(sha256Hash(passwordVecchia))) {

                // Aggiorno la password
                utenti.get(i).put("password", sha256Hash(passwordNuova));
                
                // Aggiorno il flag
                ok = true;

                // Creo una mappa per modificare la password su file
                Map<String, String> mappa = new HashMap<>();

                mappa.put("username", "");
                mappa.put("password", sha256Hash(passwordNuova));
                mappa.put("nome", "");
                mappa.put("cognome", "");
                mappa.put("email", "");

                // Aggiorno i dati dell'utente su file
                gf.modificaUtente(username, mappa);
            }
        }

        // Restituisco il flag
        return ok;
    }

    //metodo che mi permette di eliminare un account
    public boolean eliminaAccount(String username, String password){

        boolean ok=false;

        for(int i=0; i<utenti.size(); i++){

            //controllo che l'account esiste già all'interno della list
            if(utenti.get(i).get("username").equals(username)){
                
                //controllo che la password che mi è stata data è valida per l'account
                if(utenti.get(i).get("password").equals(sha256Hash(password))){
                    //elimino l'account
                    utenti.remove(utenti.get(i));

                    // Elimino l'account su file
                    ok = gf.eliminaAccount(username, sha256Hash(password));

                    break;
                }
            }
        }

        //messaggio di output per l'errore nel caso in cui inseriamo un username sbagliato
        if(!ok){
            System.out.println("Non abbiamo trovato l'username che hai inserito...");
        }

        // Restituisco il flag di terminazione
        return ok;
    }

    /**
     * @brief
     * Algoritmo SHA-256 per effettuare
     * l'hashing di una stringa
     * 
     * @param input
     * Stringa da cui estrapolare l'hash
     * 
     * @return
     * Hash della stringa
     */
    private static String sha256Hash(String input) {

        String hash = null;

        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Utilizzo la codifica UTF-8 come charset
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Conversione dei byte dell'hash in esadecimale
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashByte : hashBytes) {

                hexStringBuilder.append(String.format("%02x", hashByte));
            }

            // Aggiorno l'hash
            hash = hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

        // Restituisco l'hash calcolato
        return hash;
    }
}