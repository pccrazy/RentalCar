package CarRentalSystem.Utilities;

import javax.swing.*;

/**
 * Created by CodeCrazy on 5/2/17.
 */
public class CustomeException extends Exception {

    public CustomeException(String s){
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }

}
