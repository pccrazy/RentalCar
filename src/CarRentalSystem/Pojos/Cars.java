package CarRentalSystem.Pojos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.Utilities.JsonFileReader;

import static CarRentalSystem.Utilities.JsonFileReader.jsonToPojo;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public class Cars {

     List<Cars> cars = new ArrayList<>();
     List<companies> companies = new ArrayList<>();
     List<Available> Available = new ArrayList<>();




    private Cars() {}
    private static Cars instance;
    public static Cars getInstance() {
        if (instance == null) instance = jsonToPojo(JsonFileReader.file.Cars,Cars.class);
        return instance;
    }

    public  List<Cars> getCars() {
        return cars;
    }

    public  List<Cars.companies> getCompanies() {
        return companies;
    }

    public static class companies{
        String name;

       public String getName() {
           return name;
       }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<Cars.Available> getAvailable() {
        return Available;
    }

    public static class Available{
        int carID;
        String company;
        String name;
        int model;
        String type;
        int maxPassenger;

        public int getCarID() {
            return carID;
        }

        public void setCarID(int carID) {
            this.carID = carID;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getModel() {
            return model;
        }

        public void setModel(int model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getMaxPassenger() {
            return maxPassenger;
        }

        public void setMaxPassenger(int maxPassenger) {
            this.maxPassenger = maxPassenger;
        }
    }
}
