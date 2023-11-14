import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String userName="Lorenzo";
        String password= "1234";
        String userName2= "Francesco";
        String password2="3333";
        
        ModuloDati md= new ModuloDati();

        md.creaUtente(userName, password);

        md.creaUtente(userName2, password2);



        System.out.println(md.visualizzaInformazioni(userName));
        Map<String, String> mappaT= new HashMap<>();
        mappaT.put("nome", "lollo");
        mappaT.put("cognome", "");
        mappaT.put("email", "");
        mappaT.put("password", "");
        mappaT.put("username", "");

        
        md.modificaInformazioni(userName, mappaT);
        System.out.println(md.visualizzaInformazioni(userName));



    }
}
