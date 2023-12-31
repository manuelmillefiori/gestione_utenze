import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Architettura file per ogni utente:
 * 
 * --------
 * 
 * username
 * password
 * nome
 * cognome
 * email
 * 
 * --------
 * 
 * La riga vuota indica un campo vuoto
 */
public class GestioneFile {

   // File delle utenze
   private final String PATH_UTENTI = "utenti.dat";

   /**
    * @brief
    * Metodo per ottenere una lista di utenti
    * incapsulati in delle HashMap
    * 
    * @return
    * Lista di utenti incapsulati nelle HashMap
    */
   public List<Map<String, String>> ottieniUtenti() {

      // Alloco la lista di HashMap da restituire
      List<Map<String, String>> utenti = new ArrayList<>();

      // HashMap temporanea
      Map<String, String> tempUtente;

      // Apro il file in lettura per ottenere i dati degli utenti
      try (BufferedReader br = new BufferedReader(new FileReader(PATH_UTENTI))) {

         // Leggo fino alla fine del file
         String tempUsername;
         while ((tempUsername = br.readLine()) != null) {
            
            // Inizializzo l'HashMap temporanea
            tempUtente = new HashMap<>();

            // Ottengo e conservo i vari dati
            tempUtente.put("username", tempUsername);
            tempUtente.put("password", br.readLine());
            tempUtente.put("nome", br.readLine());
            tempUtente.put("cognome", br.readLine());
            tempUtente.put("email", br.readLine());

            // Aggiungo l'utente alla lista
            utenti.add(tempUtente);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      // Restituisco la lista degli utenti
      return utenti;
   }

   public boolean eliminaAccount(String username, String password) {
      boolean eliminato = false;

      // Apro in lettura il file delle utenze
      try (BufferedReader br = new BufferedReader(new FileReader(PATH_UTENTI));
           BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_UTENTI + ".temp", false))) {

         // Ciclo per scorrere gli utenti
         // inizializzando l'username letto
         String tempUsername;
         String tempPassword;
         while ((tempUsername = br.readLine()) != null) {
            
            // Ottengo la password
            tempPassword = br.readLine();

            // Verifico se ho trovato l'username
            if (tempUsername.equals(username) && tempPassword.equals(password)) {

               // Leggo i restanti campi
               for (int i = 0; i < 3; i++) {
                  br.readLine();
               }

               // Aggiorno il flag
               eliminato = true;
            } else {
               // Scrivo i dati dell'utente nel nuovo file temporaneo
               bw.write(tempUsername + "\n");
               bw.write(tempPassword + "\n");

               // Scrivo i restanti campi
               for (int i = 0; i < 3; i++) {
                  bw.write(br.readLine() + "\n");
               }
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      // Aggiorno il contenuto del file principale
      // aggiornando il valore del flag
      eliminato = aggiornaFile(PATH_UTENTI + ".temp", PATH_UTENTI) && eliminato;

      return eliminato;
   }

   /**
    * @brief
    * Metodo per la registrazione di un utenza su file
    * 
    * @param username
    * Username dell'utente da creare
    * 
    * @param password
    * Password dell'utente da creare
    * 
    * @return
    * true = Utente creato correttamente
    * false = Creazione utente fallita
    */
   public boolean registraUtente(Map<String, String> utente) {

      boolean registrato = false;
      
      // Apro in append il file delle utenze
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_UTENTI, true))) {

         // Salvo su file i vari dati
         bw.write(utente.get("username") + "\n" + utente.get("password") + "\n" + utente.get("nome") + "\n" + utente.get("cognome") + "\n" + utente.get("email") + "\n");

         registrato = true;
      } catch (IOException e) {

         e.printStackTrace();
      };
      
      return registrato;
   }

   /**
    * @brief
    * Metodo per modificare un utente già esistente
    * Tutti i campi vuoti dell'utente non verranno modificati
    * 
    * @param username
    * Username dell'utente da modificare
    * 
    * @param nUtente
    * Nuovo utente da inserire
    * 
    * @return
    * true = Utente modificato correttamente
    * false = Modifica dati utente fallita
    */
   public boolean modificaUtente(String username, Map<String, String> nUtente) {

      boolean modificato = false;

      // Apro in lettura il file delle utenze
      try (BufferedReader br = new BufferedReader(new FileReader(PATH_UTENTI));
           BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_UTENTI + ".temp", false))) {

         // Ciclo per scorrere gli utenti
         // inizializzando l'username letto
         String tempUsername;
         while ((tempUsername = br.readLine()) != null) {
            
            // Verifico se ho trovato l'username
            if (tempUsername.equals(username)) {

               // Inserisco i nuovi dati
               // Il readLine dopo la write serve
               // per ignorare il campo scritto sul file iniziale
               if (nUtente.get("username").equals("")) {
                  bw.write(tempUsername + "\n");
               } else {
                  bw.write(nUtente.get("username") + "\n");
               }

               if (nUtente.get("password").equals("")) {
                  bw.write(br.readLine() + "\n");
               } else {
                  bw.write(nUtente.get("password") + "\n");
                  br.readLine();
               }

               if (nUtente.get("nome").equals("")) {
                  bw.write(br.readLine() + "\n");
               } else {
                  bw.write(nUtente.get("nome") + "\n");
                  br.readLine();
               }

               if (nUtente.get("cognome").equals("")) {
                  bw.write(br.readLine() + "\n");
               } else {
                  bw.write(nUtente.get("cognome") + "\n");
                  br.readLine();
               }

               if (nUtente.get("email").equals("")) {
                  bw.write(br.readLine() + "\n");
               } else {
                  bw.write(nUtente.get("email") + "\n");
                  br.readLine();
               }

               // Aggiorno il flag
               modificato = true;
            } else {
               // Scrivo i dati dell'utente nel nuovo file temporaneo
               bw.write(tempUsername + "\n");

               // Scrivo i restanti campi
               for (int i = 0; i < 4; i++) {
                  bw.write(br.readLine() + "\n");
               }
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      // Aggiorno il contenuto del file principale
      // aggiornando il valore del flag
      modificato = aggiornaFile(PATH_UTENTI + ".temp", PATH_UTENTI);

      return modificato;
   }

   /**
    * @brief
    * Sostituisco il contenuto del file di destinazione
    * con il contenuto del file d'origine
    * 
    * @param source
    * Relative path del file d'origine
    * 
    * @param dest
    * Relative path del file di destinazione
    */
   private boolean aggiornaFile(String source, String dest)
   {
      boolean aggiornato = false;

      try {
         // Ottengo la path assoluta dei file
         Path pathSource = Paths.get(source);
         Path pathDest = Paths.get(dest);

         // Sovrascrivo il file di destinazione
         // con quello d'origine
         Files.move(pathSource, pathDest, StandardCopyOption.REPLACE_EXISTING);

         // Aggiorno il flag
         aggiornato = true;
      } catch (IOException e) {
         // Aggiorno il flga
         aggiornato = false;
      }

      return aggiornato;
   }
}