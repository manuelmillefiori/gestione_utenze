package EsercizioInGruppo;

import java.util.Scanner;

public class Interfaccia {
    public static int richiediMetodo( Cliente cliente){
        Scanner input = new Scanner(System.in);
        int scelta;
        int ritorno = 1;

        //registrazione / login
        System.out.println("");
        System.out.println("Ciao " + cliente.getNome());

        System.out.println("");
        System.out.println("1: inserisci informazioni");
        System.out.println("2: visualizza informazioni");
        System.out.println("3: modifica informazioni");
        System.out.println("5: elimina account");
        System.out.println("6: esci dal programma");
        System.out.print("Scegli la funzione > ");
        scelta = input.nextInt();
        input.nextLine();
    }
}
