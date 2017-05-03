package CarRentalSystem.Utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

import CarRentalSystem.Pojos.Available;
import CarRentalSystem.Pojos.Rented;


/**
 * Created by CodeCrazy on 4/29/17.
 */
public class CarsHelper {

     List<Available> available = new ArrayList<>();
     List<Rented>rented = new ArrayList<>();



    private CarsHelper() {}
    private static CarsHelper instance;
    public static CarsHelper getInstance() {
        if (instance == null) instance=new CarsHelper();
        return instance;
    }


    Rented[] array_rented;
    Available[] array_available;
    public List<Available> getAvailable() {
        Gson gson = new Gson();


        InputStream in =
                this
                        .getClass()
                        .getResourceAsStream("/CarRentalSystem/JsonFiles/Available.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        //convert the json string back to object
         array_available= gson.fromJson(br, Available[].class);
        if(available.isEmpty()){
            Collections.addAll(available,array_available);
        }
        return available;
    }
    public List<Rented> getRentedCars() {
        Gson gson = new Gson();

        InputStream in =
                this
                        .getClass()
                        .getResourceAsStream("/CarRentalSystem/JsonFiles/Rented.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        //convert the json string back to object
        array_rented= gson.fromJson(br, Rented[].class);
        if(rented.isEmpty()){
            Collections.addAll(rented,array_rented);
        }

        return rented;
    }


    public Available findSelectedCar(String carname) {
        return getAvailable()
                .stream()
                .filter(
                        e ->
                                new String(e.getCompany() + " " + e.getName() + " " + e.getModel())
                                        .contains(carname.trim()))
                .findFirst()
                .get();
    }

    public Available findSelectedCarById(int id) {
        return getAvailable()
                .stream()
                .filter(
                        e -> e.getCarID() == id)
                .findFirst()
                .get();
    }

    public void newRent(){
        Gson gson=new Gson();
        String json =  gson.toJson(getRentedCars());

        try {
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter(getClass().getResource("/CarRentalSystem/JsonFiles/Rented.json").getFile());
            writer.write(json);
            writer.close();

            //  write(json);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating account!, Please try again");
            e.printStackTrace();
        }
    }

    public void updateAvailableCars(){
        Gson gson=new Gson();
        String json =  gson.toJson(getAvailable());

        try {
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter(getClass().getResource("/CarRentalSystem/JsonFiles/Available.json").getFile());
            writer.write(json);
            writer.close();

            //  write(json);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating account!, Please try again");
            e.printStackTrace();
        }
    }

}