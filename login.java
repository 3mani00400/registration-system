import java.util.HashMap;
import java.util.regex.Pattern;

public class login {

    return "User registered successfully!";

    public String loginUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
        if (userDatabase.get(username).equals(password)) {
            return "Login successful!";
        } else {
            return "Incorrect password.";
        }
        } else {
            return "Username not found. Please register first";
        }
    }
}