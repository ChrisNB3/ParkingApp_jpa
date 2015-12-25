package beans;

import entity.BarriereEntreeEntity;
import generated.parking.BarriereEntree;
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
public class BarriereEntreeBean {
    @PersistenceContext private EntityManager em;
    
    public void saveState(BarriereEntree bE) {
        BarriereEntreeEntity bEE = new BarriereEntreeEntity();
        bEE.setState(bE.getState());
        em.persist(bEE);
    }
    
    public BarriereEntreeEntity loadState(int id){        
        return (BarriereEntreeEntity)em.createQuery("SELECT b FROM BarriereEntreeEntity b WHERE b.id='"+id+"'").getSingleResult();
    }
    
    public List<BarriereEntreeEntity> getSaves(){
        return em.createQuery("SELECT b FROM BarriereEntreeEntity b").getResultList();
    }
}
