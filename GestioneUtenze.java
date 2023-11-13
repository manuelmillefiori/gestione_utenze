package gestione_utenze;

class GestioneUtenze {
   public static void main(String[] args) {
      GestioneFile gf = new GestioneFile();

      // Creo 10 utenze
      Utente[] utenti = new Utente[10];
      utenti[0] = new Utente("manuelino", "spazzolino", "Manuel", "Spazzolino", "manuelino@gmail.com");
      utenti[1] = new Utente("sarah94", "password123", "Sarah", "Johnson", "sarah@example.com");
      utenti[2] = new Utente("mike87", "mikepassword", "Mike", "Smith", "mike@example.com");
      utenti[3] = new Utente("laurab", "laura1234", "Laura", "Brown", "laura@example.com");
      utenti[4] = new Utente("chrisG", "green789", "Chris", "Green", "chris@example.com");
      utenti[5] = new Utente("jenny_w", "jenPass", "Jenny", "Williams", "jenny@example.com");
      utenti[6] = new Utente("david75", "davidPass", "David", "Miller", "david@example.com");
      utenti[7] = new Utente("emmaS", "emmaPswd", "Emma", "Scott", "emma@example.com");
      utenti[8] = new Utente("ryan90", "ryanPass", "Ryan", "", "ryan@example.com");
      //utenti[9] = new Utente("oliviaJ", "olivia123", "Olivia", "Johnson", "olivia@example.com");
      //utenti[10] = new Utente("andrewR", "andrewPswd", "Andrew", "Robinson", "andrew@example.com");

      gf.registraUtente(utenti[0]);
      gf.registraUtente(utenti[1]);
      gf.registraUtente(utenti[2]);
      gf.registraUtente(utenti[3]);
      gf.registraUtente(utenti[4]);
      gf.registraUtente(utenti[5]);
      gf.registraUtente(utenti[6]);
      gf.registraUtente(utenti[7]);

      gf.modificaUtente("mike87", utenti[8]);
   }
}
