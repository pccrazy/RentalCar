package CarRentalSystem.Pojos;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.Utilities.JsonFileReader;
import CarRentalSystem.Utilities.UserHandler;

import static CarRentalSystem.Utilities.JsonFileReader.jsonToPojo;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public class User {
    List<User> Users = new ArrayList<>();
    List<User> test = new ArrayList<>();

    String username;
    String password;
    String accountType;
    String phone;
    String email;

    private User() {}
    private static User instance;
    public static User getInstance() {
        if (instance == null) instance = jsonToPojo(JsonFileReader.file.Users,User.class);
        return instance;
    }

    private final List<UserHandler> listeners = new ArrayList<>();
    public void removeListener(UserHandler listener) {
        listeners.remove(listener);
    }
    public void addListener(UserHandler listener) {
        listeners.add(listener);
    }

    public List getUsers() {
        return Users;
    }



    public void notifiySuccessLogin(){
        for(UserHandler userHandler:listeners){
            userHandler.onSuccessLogin();
        }
    }

    public void notifiyUnSuccessLogin(){
        for(UserHandler userHandler:listeners){
            userHandler.onUnSuccessLogin();
        }
    }

    public void setUsers(List users) {
        Users = users;
    }

    public void setNewUser(User user){
        Users.add(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
