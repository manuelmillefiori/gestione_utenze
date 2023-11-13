public class Main {
    public static void main(String[] args) {
        String userName="Lorenzo";
        String password= "1234";
        
        ModuloDati md= new ModuloDati();

        md.creaUtente(userName, password);


        
        System.out.println("STO PROVANDO IL LOGIN");
        if(md.logIn(userName, password))
            System.out.println("Login effettuato");
        else
            System.out.println("Login non effettuato");

        String chiaveNuova="CODICE_FISCALE";
        String valoreNuovo="GNTLRNZ141004M";

        md.aggiungiInformazioni(chiaveNuova, valoreNuovo, userName);

        md.visualizzaInformazioni(userName);

    }
}
