package gestione_utenze;

import java.util.Scanner;

public class Interfaccia {
    private Scanner input;

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
        System.out.print("Inserisci il tuo nome utente: ");
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
        System.out.print("Inserisci il tuo nome utente: ");
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
    }
    
}

