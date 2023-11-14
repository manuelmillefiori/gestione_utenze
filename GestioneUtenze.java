package gestione_utenze;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class GestioneUtenze {
   public static void main(String[] args) {
      GestioneFile gf = new GestioneFile();

      // Creo 10 utenze
      List<Map<String, String>> utenti = new ArrayList<>(10);
      Map<String, String> utente1 = new HashMap<>();
      utente1.put("username", "manuelino");
      utente1.put("password", "spazzolino");
      utente1.put("nome", "Manuel");
      utente1.put("cognome", "Spazzolino");
      utente1.put("email", "manuelino@gmail.com");
      utenti.add(utente1);
      Map<String, String> utente2 = new HashMap<>();
      utente2.put("username", "sarah94");
      utente2.put("password", "password123");
      utente2.put("nome", "Sarah");
      utente2.put("cognome", "Johnson");
      utente2.put("email", "sarah@example.com");
      utenti.add(utente2);
      Map<String, String> utente3 = new HashMap<>();
      utente3.put("username", "mike87");
      utente3.put("password", "mikepassword");
      utente3.put("nome", "Mike");
      utente3.put("cognome", "Smith");
      utente3.put("email", "mike@example.com");
      utenti.add(utente3);
      Map<String, String> utente4 = new HashMap<>();
      utente4.put("username", "laurab");
      utente4.put("password", "laura1234");
      utente4.put("nome", "Laura");
      utente4.put("cognome", "Brown");
      utente4.put("email", "laura@example.com");
      utenti.add(utente4);
      Map<String, String> utente5 = new HashMap<>();
      utente5.put("username", "chrisG");
      utente5.put("password", "green789");
      utente5.put("nome", "Chris");
      utente5.put("cognome", "Green");
      utente5.put("email", "chris@example.com");
      utenti.add(utente5);
      Map<String, String> utente6 = new HashMap<>();
      utente6.put("username", "jenny_w");
      utente6.put("password", "jenPass");
      utente6.put("nome", "Jenny");
      utente6.put("cognome", "Williams");
      utente6.put("email", "jenny@example.com");
      utenti.add(utente6);
      Map<String, String> utente7 = new HashMap<>();
      utente7.put("username", "david75");
      utente7.put("password", "davidPass");
      utente7.put("nome", "David");
      utente7.put("cognome", "Miller");
      utente7.put("email", "david@example.com");
      utenti.add(utente7);
      Map<String, String> utente8 = new HashMap<>();
      utente8.put("username", "emmaS");
      utente8.put("password", "emmaPswd");
      utente8.put("nome", "Emma");
      utente8.put("cognome", "Scott");
      utente8.put("email", "emma@example.com");
      utenti.add(utente8);
      Map<String, String> utente9 = new HashMap<>();
      utente9.put("username", "ryan90");
      utente9.put("password", "ryanPass");
      utente9.put("nome", "Ryan");
      utente9.put("cognome", "");
      utente9.put("email", "ryan@example.com");
      utenti.add(utente9);
      // Gli ultimi due utenti rimangono commentati in quanto gli indici vanno da 0 a 9
      // Se dovessero essere aggiunti, sarebbe necessario estendere la capacità dell'ArrayLi
      // Map<String, String> utente10 = new HashMap<>();
      // utente10.put("username", "oliviaJ");
      // utente10.put("password", "olivia123");
      // utente10.put("nome", "Olivia");
      // utente10.put("cognome", "Johnson");
      // utente10.put("email", "olivia@example.com");
      // utenti.add(utente10
      // Map<String, String> utente11 = new HashMap<>();
      // utente11.put("username", "andrewR");
      // utente11.put("password", "andrewPswd");
      // utente11.put("nome", "Andrew");
      // utente11.put("cognome", "Robinson");
      // utente11.put("email", "andrew@example.com");
      // utenti.add(utente11
      gf.registraUtente(utenti.get(0));
      gf.registraUtente(utenti.get(1));
      gf.registraUtente(utenti.get(2));
      gf.registraUtente(utenti.get(3));
      gf.registraUtente(utenti.get(4));
      gf.registraUtente(utenti.get(5));
      gf.registraUtente(utenti.get(6));
      gf.registraUtente(utenti.get(7));

      gf.modificaUtente("mike87", utenti.get(8));

      // Ottengo i dati di tutti gli utenti
      System.out.println(gf.ottieniUtenti());
   }
}
