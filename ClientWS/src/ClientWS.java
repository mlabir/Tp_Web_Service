import java.util.List;

import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

public class ClientWS {

        public static void main(String[] args) {

            BanqueService stubWS = new BanqueWS().getBanqueServicePort();
            System.out.println(stubWS.conversionEuroToDH(800));//l'invocation de methode a distance
            Compte cp= stubWS.getCompte(2L);
            System.out.println(cp.getCode());
            System.out.println(cp.getSolde());
            List<Compte> cptes=stubWS.listComptes();
            cptes.forEach(c->{
                System.out.println("---------------------------");
                System.out.println(c.getCode());
                System.out.println(c.getSolde());
            });

        };

    }




