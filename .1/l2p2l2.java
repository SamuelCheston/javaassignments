import java.util.Scanner;

public class l2p2l2 {
    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String last2 = name.substring(name.length() - 2);
        System.out.println("The last two characters of your name are: " + last2);
    }
}
