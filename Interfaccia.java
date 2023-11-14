package gestione_utenze;

/**
 * TODO:
 * Limitare il numero di tentativi nel login
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Interfaccia {
    private Scanner input;

    public Interfaccia() {

        // Istanzio l'handle per l'input
        input = new Scanner(System.in);

        // Mostro il menu principale
        menuPrincipale();
    }

    private void menuPrincipale() {

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

    private void interfacciaRegistrazione() {
        // Implementazione della registrazione
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("      REGISTRAZIONE     ");
        System.out.println("-------------------------");
        System.out.print("Inserisci il tuo username: ");
        String username = input.next();
        System.out.print("Inserisci la tua password: ");
        String password = input.next();
        
        // Registrazione dell'utente
        //md.registrazione(username, password);

        // Interfaccia per il login
        interfacciaLogin();
    }

    private void interfacciaLogin() {
        // Implementazione del login
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("          LOGIN         ");
        System.out.println("-------------------------");
        System.out.print("Inserisci il tuo username: ");
        String username = input.next();
        System.out.print("Inserisci la tua password: ");
        String password = input.next();

        // Login dell'utente
        //md.login
        if (login(username, password)) {

            // Mostro l'interfaccia per effettuare le operazioni
            // di CRUD sull'utente
            interfacciaCRUD(username);
        } else {

            // Fallito il login mostro il menu principale
            menuPrincipale();
        }
    }

    // Implementazione dell'interfaccia dopo il login
    private void interfacciaCRUD(String username) {
        int scelta;

        do {

            System.out.println("");
            System.out.println("1: Inserisci informazioni");
            System.out.println("2: Visualizza informazioni");
            System.out.println("3: Modifica informazioni");
            System.out.println("4: Eliminazione account");
            System.out.println("5: Esci dal programma");
            System.out.print("Scegli la funzione > ");
            scelta = input.nextInt();
            input.nextLine();

            // Switch per distinguere le operazioni
            switch (scelta) {
                case 1: {

                    // Inserimento dati utente
                    System.out.println("Invia senza inserire nulla per non inserire dati nel campo!");
                    System.out.print("Inserisci il tuo nome: ");
                    String nNome = input.nextLine();
                    System.out.print("Inserisci il tuo cognome: ");
                    String nCognome = input.nextLine();
                    System.out.print("Inserisci la tua email: ");
                    String nEmail = input.nextLine();
                    System.out.println("Informazioni inserite con successo!");

                    // Inserisco le informazioni
                    inserisciInformazioni(username, nNome, nCognome, nEmail);

                    break;
                }
                
                case 2: {
                    
                    // Visualizzo le informazioni
                    visualizzaInformazioni();

                    break;
                }

                case 3: {

                    // Inserimento nuovi dati utente
                    System.out.println("Invia senza inserire nulla per non modificare il campo!");
                    System.out.println("Nuovo username: ");
                    String nUsername = input.nextLine();
                    System.out.print("Nuovo nome: ");
                    String nNome = input.nextLine();
                    System.out.print("Nuovo cognome: ");
                    String nCognome = input.nextLine();
                    System.out.print("Nuova email: ");
                    String nEmail = input.nextLine();
                    System.out.println("Informazioni modificate con successo!");

                    // Modifico le informazioni
                    modificaInformazioni(username, nUsername, "", nNome, nCognome, nEmail);

                    break;
                }

                case 4: {

                    // Mi assicuro che l'utente voglia realmente eliminare l'account
                    System.out.println("Sei sicuro di voler eliminare il tuo account? (s/n)");
                    String risposta = input.nextLine();

                    if (risposta.equals("s")) {

                        // Rimuovo tutti i dati dell'account
                        eliminaAccount();
                        System.out.println("Account eliminato con successo!");
                    } else {

                        System.out.println("Account non eliminato!");
                    }
                    
                    break;
                }

                case 5: {

                    // Uscita dal programma
                    System.out.println("Uscita dal programma.");

                    break;
                }
            }
        } while (scelta != 5);
    }

    private boolean inserisciInformazioni(String usernameUtente, String nome, String cognome, String email) {

        // Invoco il metodo di modifica delle informazioni
        // ignorando l'email e la password
        return modificaInformazioni(usernameUtente, "", "", nome, cognome, email);
    }

    private boolean modificaInformazioni(String usernameUtente, String nUsername, String nPassword, String nNome, String nCognome, String nEmail) { 

        // Implementazione della modifica delle informazioni
        Map<String, String> utente = new HashMap<>();

        utente.put("username", nUsername);
        utente.put("password", nPassword);
        utente.put("nome", nNome);
        utente.put("cognome", nCognome);
        utente.put("email", nEmail);

        // Invoco la funzione per modificare i dati tramite
        // il modulo dati
        //md.modificaInformazioni(usernameUtente, utente);
        return true;
    }
}