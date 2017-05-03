package CarRentalSystem.Utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.*;

import CarRentalSystem.Pojos.AvailableCars;
import CarRentalSystem.Pojos.RentedCars;

/** Created by CodeCrazy on 4/29/17. */
public class CarsHelper {

  List<AvailableCars> available = new ArrayList<>();
  List<RentedCars> rented = new ArrayList<>();

  private CarsHelper() {}

  private static CarsHelper instance;

  public static CarsHelper getInstance() {
    if (instance == null) instance = new CarsHelper();
    return instance;
  }

  RentedCars[] array_rented;
  AvailableCars[] array_available;

  public List<AvailableCars> getAvailable() {
    Gson gson = new Gson();
      Path currentRelativePath = Paths.get("");
      String s = currentRelativePath.toAbsolutePath().toString();

      BufferedReader br=null;

      try {
          br = new BufferedReader(new FileReader(new File(s+"/JsonFiles/Available.json")));
        array_available = gson.fromJson(br, AvailableCars[].class);
        if (available.isEmpty()) {
          Collections.addAll(available, array_available);
        }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
    //convert the json string back to object

    return available;
  }

  public List<RentedCars> getRentedCars() {
    Gson gson = new Gson();
      Path currentRelativePath = Paths.get("");
      String s = currentRelativePath.toAbsolutePath().toString();
    BufferedReader br=null;

      try {
          br = new BufferedReader(new FileReader(new File(s+"/JsonFiles/Rented.json")));
        array_rented = gson.fromJson(br, RentedCars[].class);
        if (rented.isEmpty()) {
          Collections.addAll(rented, array_rented);
        }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
    //convert the json string back to object


    return rented;
  }

  public int getLastCarID() {
    return getAvailable()
        .stream()
        .max(Comparator.comparingInt(AvailableCars::getCarID)).get().getCarID()+1;
  }

  public AvailableCars findSelectedCar(String carname) {
    return getAvailable()
        .stream()
        .filter(
            e ->
                new String(e.getCompany() + " " + e.getName() + " " + e.getModel())
                    .contains(carname.trim()))
        .findFirst()
        .get();
  }

  public AvailableCars findSelectedCarById(int id) {
    return getAvailable().stream().filter(e -> e.getCarID() == id).findFirst().get();
  }

  public void newRent() {
    Gson gson = new Gson();
    String json = gson.toJson(getRentedCars());

    try {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
      //write converted json data to a file named "CountryGSON.json"
      FileWriter writer =
          new FileWriter(s+"/JsonFiles/Rented.json");
      writer.write(json);
      writer.close();

      //  write(json);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error on booking contact admin");
      e.printStackTrace();
    }
  }

  public void updateAvailableCars() {
    Gson gson = new Gson();
    String json = gson.toJson(getAvailable());

    try {
      //write converted json data to a file named "CountryGSON.json"
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        //write converted json data to a file named "CountryGSON.json"
        FileWriter writer =
                new FileWriter(s+"/JsonFiles/Available.json");
      writer.write(json);
      writer.close();

      //  write(json);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error creating account!, Please try again");
      e.printStackTrace();
    }
  }
}
