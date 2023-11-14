package gestione_utenze;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Interfaccia {
    private Scanner input;
    private String nome, cognome, email;

    public Interfaccia() {
        input = new Scanner(System.in);
        int scelta;

        // Implementazione del menu principale
        System.out.println("1: Registrazione");
        System.out.println("2: Login");
        System.out.println("3: Esci dal programma");
        System.out.print("Scegli un'opzione > ");
        scelta = input.nextInt();

        switch (scelta) {
            case 1:
                registrazione();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Arrivederci!");
                break;
            default:
                System.out.println("Opzione non valida. Riprova.");
        }
    }

    private void registrazione() {
        // Implementazione della registrazione
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("      REGISTRAZIONE     ");
        System.out.println("-------------------------");
        System.out.print("Inserisci il tuo username: ");
        String nomeUtente = input.next();
        System.out.print("Inserisci la tua password: ");
        String password = input.next();
        

        // Chiama login() metodo
        login();
    }

    private void login() {
        // Implementazione del login
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("          LOGIN         ");
        System.out.println("-------------------------");
        System.out.print("Inserisci il tuo username: ");
        String nomeUtente = input.next();
        System.out.print("Inserisci la tua password: ");
        String password = input.next();

        // Chiama l'interfacciaDopoLogin() metodo
        interfacciaDopoLogin();
    }

    // Implementazione dell'interfaccia dopo il login
    private void interfacciaDopoLogin() {
        int scelta;

        System.out.println("");
        System.out.println("1: Inserisci informazioni");
        System.out.println("2: Visualizza informazioni");
        System.out.println("3: Modifica informazioni");
        System.out.println("4: Elimina account");
        System.out.println("5: Esci dal programma");
        System.out.print("Scegli la funzione > ");
        scelta = input.nextInt();
        input.nextLine();

        switch (scelta) {
            case 1:
                System.out.print("Inserisci il tuo nome: ");
                nome = input.nextLine();
                System.out.print("Inserisci il tuo cognome: ");
                cognome = input.nextLine();
                System.out.print("Inserisci la tua email: ");
                email = input.nextLine();
                System.out.println("Informazioni inserite con successo!");

                //inserisciInformazioni(nomeUtente,"",nome, cognome, email);

                interfacciaDopoLogin();
            break;
            
            case 2:
                System.out.println("Nome: " + nome);
                System.out.println("Cognome: " + cognome);
                System.out.println("Email: " + email);
                interfacciaDopoLogin();
            break;

            case 3:
                System.out.print("Modifica il tuo nome: ");
                nome = input.nextLine();
                System.out.print("Modifica il tuo cognome: ");
                cognome = input.nextLine();
                System.out.print("Modifica la tua email: ");
                email = input.nextLine();
                System.out.println("Informazioni modificate con successo!");

                //modificaInformazioni(nomeUtente,"",nome, cognome, email);

                interfacciaDopoLogin();
            break;

            case 4:
                System.out.println("Sei sicuro di voler eliminare il tuo account? (s/n)");
                String risposta = input.nextLine();
                if (risposta.equals("s")) {
                System.out.println("Account eliminato con successo!");
                } else {
                System.out.println("Account non eliminato!");
                }
                interfacciaDopoLogin();
            break;

            case 5:
                System.out.println("esco dal programma");
            break;
        }
    }

    private void inserisciInformazioni(String usernameUtente, String nome, String cognome, String email) {
        // Implementazione dell'inserimento delle informazioni
        Map<String, String> utente = new HashMap<>();

        utente.put("username", "");
        utente.put("password", "");
        utente.put("nome", nome);
        utente.put("cognome", cognome);
        utente.put("email", email);

        // Invoco la funzione per registrare i dati tramite
        // il modulo dati
        //md.registraInformazioni(usernameUtente, utente);
    }

    private void modificaInformazioni(String usernameUtente, String password, String nome, String cognome, String email) {
        // Implementazione della modifica delle informazioni
        Map<String, String> utente = new HashMap<>();

        utente.put("username", "");
        utente.put("password", "");
        utente.put("nome", nome);
        utente.put("cognome", cognome);
        utente.put("email", email);

        // Invoco la funzione per modificare i dati tramite
        // il modulo dati
        //md.modificaInformazioni(usernameUtente, utente);
    }
}