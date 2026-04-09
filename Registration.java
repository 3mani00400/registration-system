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
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals ("1")) {

                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                if (userDatabase.containsKey(username)) {
                    System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
                
             } else {
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                userDatabase.put(username,password);
                System.out.println("User registered successfully!");

             }
            } else if (choice.equals("2")) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine ();
                if (userDatabase.containsKey(username)) {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (userDatabase.get(username).equals(password)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Username not found. Please register first");
                    }
                } else if (choice.equals("3")) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }}


