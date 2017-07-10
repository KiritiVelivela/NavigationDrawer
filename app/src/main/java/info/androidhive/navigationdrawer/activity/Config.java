package info.androidhive.navigationdrawer.activity;

/**
 * Created by srilu on 6/14/17.
 */

public class Config {

    //URL to our login file
    public static final String LOGIN_URL = "http://192.168.0.2:3000/auth/login";

    //Keys for email and password as defined in our login
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final int LOGIN_SUCCESS = 0;

    //role
    public static final String SHARED_ROLE = "role";
    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    public static final String AUTHTOKEN_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
