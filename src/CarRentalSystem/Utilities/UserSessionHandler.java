package CarRentalSystem.Utilities;

import java.util.Arrays;

import CarRentalSystem.Pojos.User;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public interface UserSessionHandler {

    static void login(String username, String passwrod){
            UserHelper user = UserHelper.getInstance();
    boolean found =
        user.getUsers().stream()
            .filter(
                o -> {
                  User validator = o;
                  return validator.getUsername().equals(username)
                      && validator.getPassword().equals(passwrod);
                })
            .findFirst()
            .isPresent();
            if(found){
                user.notifiySuccessLogin();
            }else{
                user.notifiyUnSuccessLogin();
            }
    }

    void onNewAccountCreated();
    void onSuccessLogin();
    void onUnSuccessLogin();


}
