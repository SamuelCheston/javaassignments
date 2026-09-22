import java.util.Scanner;

public class l6p2login {
    public static void main(String[] args) {
        String username = "ICS4U";
        String password = "123";
        String enteredUsername;
        String enteredPassword;

       Scanner input = new Scanner(System.in);

       do {
        System.out.print("Enter username: ");
        enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        enteredPassword = input.nextLine();
    } while (!enteredUsername.equals(username) || !enteredPassword.equals(password));
    System.out.println("Login successful!");
        

        input.close();
    }
}
