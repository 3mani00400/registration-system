import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Message {
    String id;
    String hash;
    String recipient;
    String content;

    public Message(String id, String recipient, String content) {
        this.id = id;
        this.recipient = recipient;
        this.content = content;
        this.hash = generateHash();
    }

    private String generateHash() {
        // Hash format: first two digits of ID : message number (we'll set 0 for now) : first+last word
        String[] words = content.split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return (id.substring(0, 2) + ":0:" + firstWord + lastWord).toUpperCase();
    }

    @Override
    public String toString() {
        return "Message ID: " + id +
               "\nMessage Hash: " + hash +
               "\nRecipient: " + recipient +
               "\nMessage: " + content + "\n";
    }
}

public class QuickChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> userDatabase = new HashMap<>();
        ArrayList<Message> messageList = new ArrayList<>();

        System.out.println("Welcome to QuickChat.");

        // Registration for demonstration purposes
        System.out.print("Enter username (<5 chars with _): ");
        String username = scanner.nextLine();
        while (!(username.contains("_") && username.length() <= 5)) {
            System.out.println("Invalid username. Try again.");
            username = scanner.nextLine();
        }

        System.out.print("Enter phone number (+27XXXXXXXXXX): ");
        String phone = scanner.nextLine();
        while (!phone.matches("\\+27\\d{9}")) {
            System.out.println("Invalid phone number. Try again.");
            phone = scanner.nextLine();
        }

        System.out.print("Enter password (8+ chars, 1 capital, 1 number, 1 special): ");
        String password = scanner.nextLine();
        while (!(password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") &&
                 password.matches(".*[!@#$%^&*()-+].*") && password.length() >= 8)) {
            System.out.println("Invalid password. Try again.");
            password = scanner.nextLine();
        }

        userDatabase.put(username, password);
        System.out.println("Registration successful!\n");

        while (true) {
            System.out.println("Menu Options:");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recent messages");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                // Login
                System.out.print("Enter username: ");
                String loginUser = scanner.nextLine();
                System.out.print("Enter password: ");
                String loginPass = scanner.nextLine();

                if (!userDatabase.containsKey(loginUser) || !userDatabase.get(loginUser).equals(loginPass)) {
                    System.out.println("Invalid username or password.\n");
                    continue;
                }

                System.out.println("Login successful!");

                System.out.print("How many messages would you like to send? ");
                int numMessages = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < numMessages; i++) {
                    System.out.print("Enter recipient (+27XXXXXXXXX): ");
                    String recipient = scanner.nextLine();
                    while (!recipient.matches("\\+27\\d{9}")) {
                        System.out.println("Cellphone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                        recipient = scanner.nextLine();
                    }

                    System.out.print("Enter message (max 250 chars): ");
                    String content = scanner.nextLine();
                    while (content.length() > 250) {
                        System.out.println("Please enter a message of less than 250 characters.");
                        content = scanner.nextLine();
                    }

                    // Generate unique 10-digit message ID
                    String msgId = String.format("%010d", ThreadLocalRandom.current().nextInt(0, 1000000000));

                    Message msg = new Message(msgId, recipient, content);

                    // Send/Disregard/Store options
                    System.out.println("Choose option for this message:");
                    System.out.println("1. Send Message (Message successfully sent)");
                    System.out.println("2. Disregard Message (Press 0 to delete the message)");
                    System.out.println("3. Store Message (Message successfully stored)");
                    System.out.print("Enter choice: ");
                    String msgChoice = scanner.nextLine();

                    if (msgChoice.equals("1")) {
                        System.out.println("Message successfully sent.\n");
                        messageList.add(msg);
                    } else if (msgChoice.equals("2")) {
                        System.out.println("Message deleted.\n");
                    } else if (msgChoice.equals("3")) {
                        System.out.println("Message successfully stored.\n");
                        messageList.add(msg);
                    } else {
                        System.out.println("Invalid choice. Message discarded.\n");
                    }
                }

            } else if (choice.equals("2")) {
                System.out.println("Coming Soon.");

            } else if (choice.equals("3")) {
                System.out.println("\nThank you for your time!");
                System.out.println("All messages sent:");
                for (Message m : messageList) {
                    System.out.println(m);
                }
                System.out.println("Total messages sent: " + messageList.size());
                break;
            } else {
                System.out.println("Invalid choice. Try again.\n");
            }
        }
        scanner.close();
    }
}