package CarRentalSystem.Pojos;

/**
 * Created by CodeCrazy on 4/30/17.
 */
public class Session {

    static String currentUserName;

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        Session.currentUserName = currentUserName;
    }
}
