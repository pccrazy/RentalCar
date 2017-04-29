package CarRentalSystem;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import CarRentalSystem.Pojos.Cars;
import CarRentalSystem.Pojos.User;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public class testClass {

    @Test
    public void getCarsList(){
        Cars cars=Cars.getInstance();
        cars.getCars().get(0).getCompanies().forEach(e->System.out.println(e.getName()));
        cars.getCars().get(0).getAvailable().forEach(e->System.out.println(e.getName()));

    }
}
