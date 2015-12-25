/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author anatole
 */
public class Controller implements ActionListener{

    private final Model mModel;
    private final MainFrame mFrame;

    public Controller(Model model, MainFrame frame) 
    {
        this.mModel = model;
        this.mFrame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == mFrame.getEnterEmploye())
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mModel.enterEmploye();                
                }
            });
            thread.start();
        }
        else if(ae.getSource() == mFrame.getEnterVisiteur())
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mModel.enterVisitor();
                }
            });
            thread.start();
        }
        else if(ae.getSource() == mFrame.getOut())
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mModel.getOut();
                }
            });
            thread.start();
        }        
    }
}
