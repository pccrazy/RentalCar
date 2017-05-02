package CarRentalSystem.Utilities;

/**
 * Created by Radcliffe Brown-H000063206-CKIT-510-2-Week5-6 30/04/2017
 */

import CarRentalSystem.Pojos.Error;

import java.io.*;

public interface ErrorHandler {

    Error myerr = Error.getErrorInstance();
    public void systemError() throws IOException;
    public void integerError() throws NumberFormatException;
    public void rangeError() throws ArrayIndexOutOfBoundsException;

    static String ValidateInput (String myString) {
        try {
            //return (myString);
            Double.parseDouble(myString);
            return (myString);

        } catch (NumberFormatException e) {
            System.err.println("Invalid entry: " + myString);
            return myString;
        }
    }

    default String getErrorStatus(String myString) {
        return (ValidateInput(myString));}

}









