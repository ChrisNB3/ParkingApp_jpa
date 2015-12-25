package generated.parking;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapteurEntree {

	public static boolean detect() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CapteurEntree.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return true;
	}
}