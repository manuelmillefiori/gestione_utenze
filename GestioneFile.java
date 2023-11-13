package gestione_utenze;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
 */
class GestioneFile {

   // File delle utenze
   private final String PATH_UTENTI = "utenti.dat";

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
   public boolean registraUtente(String username, String password)
   {
      boolean registrato;
      
      // Apro in append il file delle utenze
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_UTENTI, true))) {

         // Salvo su file i vari dati
         bw.write(username + "\n" + password + "\n" + "\n" + "\n" + "\n");
      } catch (IOException e) {

         e.printStackTrace();
      };
      
      return registrato;
   }

   /**
    * @brief
    * Metodo per modificare un utente già esistente
    * La stringa vuota identifica che il campo dell'utente
    * non deve essere modificato
    * 
    * @param username
    * Username dell'utente da modificare
    * 
    * @param nUsername
    * Nuovo username dell'utente
    * 
    * @param nNome
    * Nuovo nome dell'utente
    * 
    * @param nCognome
    * Nuovo cognome dell'utente
    * 
    * @param nEmail
    * Nuova email dell'utente
    * 
    * @return
    * true = Utente modificato correttamente
    * false = Modifica dati utente fallita
    */
   public boolean modificaUtente(String username, String nUsername, String nNome, String nCognome, String nEmail)
   {

   }
}