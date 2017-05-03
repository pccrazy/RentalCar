package CarRentalSystem.Utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

import CarRentalSystem.Pojos.CurrentUser;
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

      Path currentRelativePath = Paths.get("");
      String s = currentRelativePath.toAbsolutePath().toString();

      BufferedReader br = null;
      try {
           br = new BufferedReader(new FileReader(new File(s+"/JsonFiles/Users.json")));
           System.out.println(s+"/JsonFiles/Users.json");
           users = gson.fromJson(br, User[].class);
          if(Users.isEmpty()){
              Collections.addAll(Users,users);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }

      //convert the json string back to object


      return Users;
  }

  public void addNewUser(User user){
      getUsers();
      Users.add(user);
      CurrentUser.setType("normal");
      CurrentUser.setUsername(user.getUsername());
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

            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer =
                    new FileWriter(s+"/JsonFiles/Users.json");
            writer.write(json);
            writer.close();
            for (UserSessionHandler userHandler : listeners) {
                userHandler.onNewAccountCreated();
            }
          //  write(json);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating account!, Please try again");
            e.printStackTrace();
        }

    }

}
