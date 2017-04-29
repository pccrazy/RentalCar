/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRentalSystem.Forms;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author H121709
 */
public class Objectorientedprogram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ObjectorientedprogramMainForm ObjectOrientedProgramGUI = new ObjectorientedprogramMainForm();
        
        ObjectOrientedProgramGUI.setTitle("The Rental Car Commpany");
           
        ObjectOrientedProgramGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        ObjectOrientedProgramGUI.setPreferredSize(new Dimension(1080, 750));
                      
        ObjectOrientedProgramGUI.pack();
            
        ObjectOrientedProgramGUI.setLocationRelativeTo(null);
          
        ObjectOrientedProgramGUI.setVisible(true);
        

    }
    
}
