package beans;

import entity.ParkingEntity;
import generated.parking.Parking;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nico
 */
@Stateless
@DataSourceDefinition(
        name="java:app/jdbc/ParkingDB",
        className="org.apache.derby.jdbc.ClientDriver",
        user="nbuser",
        password="nbuser",
        databaseName="ParkingDB",
        serverName="localhost",
        portNumber=1527,
        properties={"url=jdbc:derby://localhost:1527/ParkingDB"}
        )
public class ParkingBean {
    @PersistenceContext private EntityManager em;
    
    public void saveState(Parking parking) {
        ParkingEntity p = new ParkingEntity();
        p.setNbPlace(parking.getNbPlace());
        p.setCurrentNumber(parking.getCurrentNumber());
        em.persist(p);
    }
    
    public ParkingEntity loadState(int id){
        ParkingEntity p = (ParkingEntity)em.createQuery("SELECT b FROM ParkingEntity b WHERE b.id='"+id+"'").getSingleResult();
        return p;
    }
    
    public List<ParkingEntity> getSaves(){
        return em.createQuery("SELECT b FROM ParkingEntity b").getResultList();
    }
}
