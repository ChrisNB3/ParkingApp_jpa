package beans;

import entity.BarriereSortieEntity;
import generated.parking.BarriereSortie;
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
public class BarriereSortieBean {
    @PersistenceContext private EntityManager em;
    
    public void saveState(BarriereSortie bS) {
        BarriereSortieEntity bSE = new BarriereSortieEntity();
        bSE.setState(bS.getState());
        em.persist(bSE);
    }
    
    public BarriereSortieEntity loadState(int id){
        return (BarriereSortieEntity)em.createQuery("SELECT b FROM BarriereSortieEntity b WHERE b.id='"+id+"'").getSingleResult();        
    }
    
    public List<BarriereSortieEntity> getSaves(){
        return em.createQuery("SELECT b FROM BarriereSortieEntity b").getResultList();
    }
}
