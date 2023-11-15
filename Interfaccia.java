/**
 * TODO:
 * Limitare il numero di tentativi nel login
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Interfaccia {

    // Handle per l'input
    private Scanner input;

    // Modulo dati per interrogare il gestore dati
    private ModuloDati md;

    /**
     * @brief
     * Costruttore per inizializzare l'interfaccia e istanziare
     * i vari handle
     */
    public Interfaccia() {

        // Istanzio l'handle per l'input
        input = new Scanner(System.in);

        // Istanzio l'handle per utilizzare il modulo dati
        md = new ModuloDati();

        // Mostro il menu principale
        menuPrincipale();
    }

    /**
     * @brief
     * Metodo per mostrare il menu principale
     */
    private void menuPrincipale() {

        int scelta;

        do {

            // Implementazione del menu principale
            System.out.println("1: Registrazione");
            System.out.println("2: Login");
            System.out.println("3: Esci dal programma");
            System.out.print("Scegli un'opzione > ");
            scelta = input.nextInt();

            // Gestione scelta
            switch (scelta) {
                case 1: {

                    interfacciaRegistrazione();

                    break;
                }
                case 2: {

                    interfacciaLogin();

                    break;
                }
                case 3: {

                    System.out.println("Arrivederci!");

                    break;
                }
                default: {
                    
                    System.out.println("Opzione non valida. Riprova.");
                }
            }
        } while (scelta != 3);
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
        md.registrazione(username, password);

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

        // Vado a capo
        System.out.println();

        // Login dell'utente
        if (md.login(username, password)) {

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

        boolean uscita = false;

        do {

            System.out.println();
            System.out.println("1: Inserisci informazioni");
            System.out.println("2: Visualizza informazioni");
            System.out.println("3: Modifica informazioni");
            System.out.println("4: Cambia password");
            System.out.println("5: Eliminazione account");
            System.out.println("6: Esci dal programma");
            System.out.print("Scegli la funzione -> ");
            scelta = input.nextInt();
            input.nextLine();

            // Vado a capo
            System.out.println();

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
                    visualizzaInformazioni(username);

                    break;
                }

                case 3: {

                    // Inserimento nuovi dati utente
                    System.out.println("Invia senza inserire nulla per non modificare il campo!");
                    System.out.print("Nuovo username: ");
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
                    System.out.print("Inserisci la vecchia password: ");
                    String vecchiaPassword = input.nextLine();
                    System.out.print("Inserisci la nuova password: ");
                    String nuovaPassword = input.nextLine();

                    // Modifica della password
                    if (md.modificaPassword(username, vecchiaPassword, nuovaPassword)) {

                        System.out.println("Password modificata correttamente!");
                    } else {

                        System.out.println("Password errata!");
                    }

                    break;
                }

                case 5: {

                    // Mi assicuro che l'utente voglia realmente eliminare l'account
                    System.out.print("Sei sicuro di voler eliminare il tuo account? (s/n): ");
                    String risposta = input.nextLine();

                    // Password di conferma per l'eliminazione dell'account
                    System.out.print("Inserisci la password: ");
                    String password = input.nextLine();

                    if (risposta.equals("s")) {

                        // Rimuovo tutti i dati dell'account
                        if (md.eliminaAccount(username, password)) {

                            System.out.println("Account eliminato con successo!");

                            // Aggiorno il flag d'uscita
                            uscita = true;
                        } else {

                            System.out.println("Password errata!");
                        }
                    } else {

                        System.out.println("Account non eliminato!");
                    }
                    
                    break;
                }

                case 6: {

                    // Uscita dal programma
                    System.out.println("Uscita dal programma.");

                    // Aggiorno il flag d'uscita
                    uscita = true;

                    break;
                }
            }
        } while (!uscita);
    }

    private void visualizzaInformazioni(String username) {

        // Ottengo i dati dell'utente dal modulo dati
        Map<String, String> utente = md.visualizzaInformazioni(username);

        // Stampo i dati relativi all'utente
        if (!utente.get("username").equals("")) {

            System.out.println("Username: " + utente.get("username"));
        }
        // Stampo i dati relativi all'utente
        if (!utente.get("nome").equals("")) {

            System.out.println("Nome: " + utente.get("nome"));
        }
        // Stampo i dati relativi all'utente
        if (!utente.get("cognome").equals("")) {

            System.out.println("Cognome: " + utente.get("cognome"));
        }
        // Stampo i dati relativi all'utente
        if (!utente.get("email").equals("")) {

            System.out.println("Email: " + utente.get("email"));
        }
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
        return md.modificaInformazioni(usernameUtente, utente);
    }
}