package CarRentalSystem;

import org.junit.jupiter.api.Test;

import CarRentalSystem.Pojos.User;

/**
 * Created by CodeCrazy on 5/1/17.
 */
public class TestClass {
    @Test
    public void addUser() {

        //JsonFileReader.WriteToJson();
        User user2 = new User();

        user2.setUsername("test");
        user2.setPassword("test");
        user2.setPhone("test");
        user2.setEmail("test");
        user2.setAccountType("normal");
//        user2.setNewUser(user2);
//        user2.getUsers().add(user2);
//        JsonFileReader.WriteToJson(JsonFileReader.file.Users,User2.class);
//        System.out.println(user2.getUsers().size());

    }
}