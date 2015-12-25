package generated.parking;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

/**
 * @author yo
 */
public class Simulateur {

	public static void simulate(int nbTours) {
		while (nbTours > 0){
                    if(rand() > 50 && !Parking.getInstance().isPlein())//Un véhicule entre
                    {
                        System.out.println("Une personne veut entrer");
                        //Creation des personnes
                        Personne p;
                        int randomNumber = rand();
                        if(randomNumber > 50)
                        {
                            System.out.println("Cette personne est un employé");
                            BadgeEmploye b = new BadgeEmploye("test", randomNumber, randomNumber);
                            p = new Employe((BadgeEmploye) b);
                        }
                        else
                        {
                            System.out.println("Cette personne est un visiteur");
                            BadgeVisiteur b = new BadgeVisiteur(Date.from(Instant.now()), randomNumber);
                            p = new Visiteur(b);
                        }

                        //entrée d'un véhicule
                        System.out.println("Check du badge");
                        if(Badgeuse.getInstance().checkBadge(p.getBadge()))
                        {
                            System.out.println("OK, la personne rentre");
                            BarriereEntree.getInstance().open();
                            CapteurEntree.detect();
                            BarriereEntree.getInstance().close();
                            Parking.getInstance().addVehicule();
                        }
                        else{
                            System.out.println("Pas OK, la personne rentre pas, bye bye");
                        }
                    }
                    else if(Parking.getInstance().getVehiculeNumber() > 0)  //Un véhicule sort
                    {
                        System.out.println("Une personne sort");
                        BarriereSortie.getInstance().open();
                        while(CapteurSortie.detect());
                        BarriereSortie.getInstance().close();
                        Parking.getInstance().removeVehicule();
                    }
                    System.out.println("---");
                    nbTours--;
                }
                System.out.println("Fin de la simulation.");
	}
        
        public static int rand()
        {
            Random rand = new Random();
            int randomNumber = rand.nextInt(101);
            return randomNumber;
        }
        
        public static void main(String[] argv){
            simulate(50);
        }
}