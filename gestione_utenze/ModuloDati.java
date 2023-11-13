import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuloDati{
    //creo una list di map, che contengono le informazioni degli utenti
    private List<Map<String, String>> utenti = new ArrayList<>();
    

    //metodo creaUtente che mi controlla se l'utente esiste già, e se non esiste me lo crea
    public void creaUtente(String userName, String password){
        
        //creo una map temporanea a cui poi assegno i valori che mi sono stati dati 
        Map<String, String> utenteT = new HashMap<>(); 
        utenteT.put("USERNAME", userName);
        utenteT.put("PASSWORD", password);

        //inizializzo una variabile booleana a false
        boolean ok=false;

        //scorro tutti gli utenti e controllo se contengono l'username che ho dato a questo metodo
        for(int i=0; i<utenti.size(); i++){
            
                if (utenti.get(i).containsValue(userName)) {
                    //se effettivamente l'utente già c'è all'interno della nostra list allora inizializzo ok a true
                    ok=true; 
                }else{
                    //se invece non c'è ancora inizializzo ok a false
                    ok=false;
                }
            
        }
        
        //controllo dell'ok e messaggi di output
        if(ok){
            //messaggio di output nel caso in cui l'username è stato già registrato in precedenza
            System.out.println("Nome utente gia in uso");
        }else{
            //nel caso in cui non è stato già registrato lo creo dandogli l'username e la password, ma mettendo gli altri campi vuoti
            utenteT.put("USERNAME", userName);
            utenteT.put("PASSWORD", password);
            utenteT.put("NOME", "");
            utenteT.put("COGNOME", "");
            utenti.add(utenteT);
            //messaggio di output che mi conferma che l'utente è stato creato
            System.out.println("UTENTE CREATO");
        }
    }

    
    //funzione che mi ritorna un valore true se il login si può effettuare e false se non si può effettuare
    public boolean logIn(String userName, String password){
        //inizializzo una variabile booleana da returnare al main, e che modifico nei vari controlli
        boolean ok=false;

        //Scorro tutta la list di utenti
        for(int i=0; i<utenti.size(); i++){
            
            //se la list non è vuota ma presenta già degli utenti allora mi entra nel codice
            if(utenti.size()!=0){

                //controllo se l'username inserito c'è nella list
                if (utenti.get(i).containsValue(userName)) {

                    //controllo se la password che mi è arrivata è quella registrata per l'username che mi è arrivato
                    if(utenti.get(i).get("PASSWORD").equals(password)){

                        //se tutte le condizioni sono vere allora mi inizializza la variabile ok a true
                        ok=true;
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

    public void aggiungiInformazioni(String chiaveNuova, String valoreNuovo, String userName){
        boolean ok=false;
        
        for(int i=0; i<utenti.size(); i++){
            
            if (utenti.get(i).containsValue(userName)) {

                utenti.get(i).put(chiaveNuova, valoreNuovo);
            }else{
                System.out.println("Non abbiamo trovato l'utente che ha il nome che hai inserito...");
            }
        }
    }



    public Map visualizzaInformazioni(String userName){
        

        //inizializzo una map da returnare con i valori che mi servono a null
        Map<String, String> finalvalue = null;


        for(int i=0; i<utenti.size(); i++){
            
            if (utenti.get(i).containsValue(userName)) {
                
                //se l'utente già esiste inizializzo la map temporanea con le informazioni che devo stampare nel main
                finalvalue=utenti.get(i);

            }
        }

        //se non ho trovato l'utente mi ritorna di default una map null
        return finalvalue;
    }

    public void modificaInformazioni(String userName, String chiave){


        
        for(int i=0; i<utenti.size(); i++){
            if (utenti.get(i).containsValue(userName)) {
                if(utenti.get(i).get()){

                }
            }
        }




    }








}