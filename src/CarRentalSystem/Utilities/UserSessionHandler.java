package CarRentalSystem.Utilities;

import CarRentalSystem.Pojos.CurrentUser;
import CarRentalSystem.Pojos.User;

public interface UserSessionHandler {

    static void login(String username, String passwrod){
            UserHelper user = UserHelper.getInstance();
    boolean found =
        user.getUsers().stream()
            .filter(
                o -> {
                  User validator = o;
                   boolean exist= validator.getUsername().equals(username)
                            && validator.getPassword().equals(passwrod);
                   if(exist){
                       CurrentUser.setUsername(validator.getUsername());
                       CurrentUser.setType(validator.getAccountType());
                   }
                  return exist;
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
