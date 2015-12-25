package mvc;

import javax.ejb.embeddable.EJBContainer;

/**
 *
 * @author anatole
 */
public class Application {
    
    private Model mModel;
    private Controller mController;
    private MainFrame mMainFrame;

    public Application() {
        // model parking
        this.mModel = new Model();
        this.mMainFrame = new MainFrame();

        // controller parking
        this.mController = new Controller(this.mModel,this.mMainFrame);
        
        this.mMainFrame.setVisible(true);
        this.mMainFrame.addController(this.mController);
        
        this.mModel.addObserver(mMainFrame);
        
        this.mModel.initialize();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Application application = new Application();
    }
}
