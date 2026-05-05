import java.util.HashMap;
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        HashMap<String, String> userDatabase = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        
        while (true) {
            System.out.println("Please pick an option");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals ("1")) {

                System.out.print("Enter your email address: ");
                String email = scanner.nextLine();

// Validate username should contain an underscore and be no more than five characters in length      
                System.out.print("Enter your username: (< 5 characters with underscore) ");
                String username = scanner.nextLine().trim();
                if (!(username.contains("_") && username.length() <= 5)) {
                    System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
                    } else {
            System.out.println("Username successfully captured.");
        }
                
// Validate phone number should be in the format of digits only and be 10 digits long
                System.out.print("Enter your phone number: (10 digits) ");
                String phoneNumber = scanner.nextLine().trim();
                if (!(phoneNumber.matches("\\d{10}"))) {
                    System.out.println("Phone number is incorrectly formatted or does not contain international code.");
              } else {
            System.out.println("Phone number successfully added.");
        }
             
                System.out.print("Enter your password: (At least 8 characters, with a capital letter, a number and a special character) ");
                String password = scanner.nextLine().trim();
                if (!(password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()-+].*") && password.length() >= 8)) {
                    System.out.println("Password is not correctly formatted; please ensure that your password contains at least 8 characters, a capital letter, a number and a special character.");
                } else {
                    userDatabase.put(username, password);
                    System.out.println("User registered successfully!");
               }
            } else if (choice.equals("2")) {
                // Login
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                if (userDatabase.containsKey(username)) {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (userDatabase.get(username).equals(password)) {
                        System.out.println("Welcome <first name>, <last name> it is great to see you!");
                    } else {
                        System.out.println("Incorrect password.");
                    }
                } else {
                    System.out.println("Username or password incorrect, please try again.");
                }
            } 
        }
    }
}

    



