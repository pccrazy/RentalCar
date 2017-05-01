package CarRentalSystem.Utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CarRentalSystem.Pojos.User;

/** Created by CodeCrazy on 4/29/17. */
public class UserHelper {

  List<User> Users = new ArrayList<>();
  User[] users;

  private UserHelper() {}

  private static UserHelper instance;

  public static UserHelper getInstance() {
    if (instance == null) instance = new UserHelper();
      return instance;
  }

  private final List<UserSessionHandler> listeners = new ArrayList<>();

  public void removeListener(UserSessionHandler listener) {
    listeners.remove(listener);
  }

  public void addListener(UserSessionHandler listener) {
    listeners.add(listener);
  }

  public  List<User> getUsers() {
     Gson gson = new Gson();

      System.out.println("Reading JSON from a file");
      System.out.println("----------------------------");

      InputStream in =
              this
                      .getClass()
                      .getResourceAsStream("/CarRentalSystem/JsonFiles/Users.json");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));

      //convert the json string back to object
      users = gson.fromJson(br, User[].class);
      if(Users.isEmpty()){
          Collections.addAll(Users,users);
      }
      return Users;
  }

  public void addNewUser(User user){
      getUsers();
      Users.add(user);
  }

  public void notifiySuccessLogin() {
    for (UserSessionHandler userHandler : listeners) {
      userHandler.onSuccessLogin();
    }
  }

  public void notifiyUnSuccessLogin() {
    for (UserSessionHandler userHandler : listeners) {
      userHandler.onUnSuccessLogin();
    }
  }

    public void createNewUser() {
        Gson gson=new Gson();
        String json =  gson.toJson(Users);

        try {
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter(getInstance().getClass().getResource("/CarRentalSystem/JsonFiles/Users.json").getFile());
            writer.write(json);
            writer.close();
            for (UserSessionHandler userHandler : listeners) {
                userHandler.onNewAccountCreated();
            }
          //  write(json);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
