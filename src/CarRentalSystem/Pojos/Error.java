package CarRentalSystem.Pojos;

import CarRentalSystem.Utilities.ErrorHandler;

import javax.swing.*;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.IndexOutOfBoundsException;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Created by Radcliffe Brown-H000063206-CKIT-510-2-Week5-6 30/04/2017
 */

public class Error {

    private static Error instance;
    public static Error getErrorInstance() {
        if (instance == null) instance = new Error();
        return instance;
    }

    public void systemError() throws IOException{
        JOptionPane.showMessageDialog(null, "System error!, Please try again");
    }
    public void  integerError() throws NumberFormatException{
        JOptionPane.showMessageDialog(null, "Invalid string!, Please try again");}
    public void rangeError() throws ArrayIndexOutOfBoundsException{
        JOptionPane.showMessageDialog(null, "Invalid range Error!, Please try again");
    }


    //void onSuccessInput();
    //void onUnSuccessInput();
}
