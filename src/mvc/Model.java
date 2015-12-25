package mvc;

import generated.parking.BadgeEmploye;
import generated.parking.BadgeVisiteur;
import generated.parking.Badgeuse;
import generated.parking.BarriereEntree;
import generated.parking.BarriereSortie;
import generated.parking.CapteurEntree;
import generated.parking.CapteurSortie;
import generated.parking.Employe;
import generated.parking.Parking;
import generated.parking.Personne;
import static generated.parking.Simulateur.rand;
import generated.parking.Visiteur;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author anatole
 */
public class Model extends Observable{
    
    public Model() 
    {
    }
    
    public void initialize()
    {
        this.setChanged();
        this.notifyObservers(BarriereEntree.getInstance());
        
        this.setChanged();
        this.notifyObservers(BarriereSortie.getInstance());

        this.setChanged();
        this.notifyObservers(Parking.getInstance());
        
    }
    
    public void enterEmploye()
    {
        Personne p;
        int randomNumber = rand(50);

        BadgeEmploye b = new BadgeEmploye("test", randomNumber, randomNumber);
        p = new Employe((BadgeEmploye) b);
        
        synchronized(this)
        {
            if(Parking.getInstance().isPlein())
            {
                return;
            }

            if(Badgeuse.getInstance().checkBadge(p.getBadge()))
            {
                BarriereEntree.getInstance().open();

                this.setChanged();
                this.notifyObservers(BarriereEntree.getInstance());

                CapteurEntree.detect();

                this.setChanged();
                this.notifyObservers(BarriereEntree.getInstance());

                BarriereEntree.getInstance().close();

                this.setChanged();
                this.notifyObservers(BarriereEntree.getInstance());

                Parking.getInstance().addVehicule();

                this.setChanged();
                this.notifyObservers(Parking.getInstance());
            }
        }
    }
    
    public void enterVisitor()
    {
        Personne p;
        int randomNumber = rand(50);

        BadgeVisiteur b = new BadgeVisiteur(Date.from(Instant.now()), randomNumber);
        p = new Visiteur(b);

        synchronized(this)
        {
            if(Parking.getInstance().isPlein())
            {
                return;
            }

            if(Badgeuse.getInstance().checkBadge(p.getBadge()))
            {
                BarriereEntree.getInstance().open();

                this.setChanged();
                this.notifyObservers(BarriereEntree.getInstance());

                CapteurEntree.detect();

                BarriereEntree.getInstance().close();

                this.setChanged();
                this.notifyObservers(BarriereEntree.getInstance());

                Parking.getInstance().addVehicule();

                this.setChanged();
                this.notifyObservers(Parking.getInstance());
            }
        }
    }
    
    public void getOut()
    {
        synchronized(this)
        {
            if(Parking.getInstance().isEmpty())
                return;
            
            System.out.println("Une personne sort");
            BarriereSortie.getInstance().open();
            
            this.setChanged();
            this.notifyObservers(BarriereSortie.getInstance());

            CapteurSortie.detect();
            BarriereSortie.getInstance().close();
            
            this.setChanged();
            this.notifyObservers(BarriereSortie.getInstance());

            Parking.getInstance().removeVehicule();
            
            this.setChanged();
            this.notifyObservers(Parking.getInstance());
        }
    }
    
    public static int rand(int max)
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(max);
        return randomNumber;
    }   
}
