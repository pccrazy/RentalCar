package CarRentalSystem.Utilities;

import CarRentalSystem.Pojos.User;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public interface UserHandler {

    static void login(String username, String passwrod){
            User user = User.getInstance();
            boolean found = user.getUsers().stream().filter(o -> {
                User validator=(User)o;
                return validator.getUsername().equals(username)
                        && validator.getPassword().equals(passwrod);
            }).findFirst().isPresent();
            if(found){
                user.notifiySuccessLogin();
            }else{
                user.notifiyUnSuccessLogin();
            }
    }

    void onSuccessLogin();
    void onUnSuccessLogin();

}
