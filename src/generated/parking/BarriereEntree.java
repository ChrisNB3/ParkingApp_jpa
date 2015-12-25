package generated.parking;

/**
 * @author yo
 */
public class BarriereEntree {   

    private String state;
    private static BarriereEntree barriere;

    private BarriereEntree() {
        this.state = "close";
    }
    
    public static BarriereEntree getInstance(){
        if(barriere==null) barriere=new BarriereEntree();
        return barriere;
    }
    
    public String getState()
    {
        return this.state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public void open() {
        System.out.println("La barriere d'entrée s'ouvre");
            state="open";
    }

    public void close() {
        System.out.println("La barriere d'entrée se ferme");
            state="close";
    }
    
}