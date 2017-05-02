package CarRentalSystem.Utilities;

import javax.swing.*;

public class CustomeException extends Exception {
    public CustomeException(String s){
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }
}