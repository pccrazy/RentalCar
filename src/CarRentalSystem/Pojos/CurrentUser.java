package CarRentalSystem.Pojos;

/**
 * Created by CodeCrazy on 4/29/17.
 */
public abstract class CurrentUser{
    public static String username;

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        CurrentUser.type = type;
    }

    public static String type;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUser.username = username;
    }
}
