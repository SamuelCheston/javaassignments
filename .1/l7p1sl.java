import java.util.Scanner;
public class l7p1sl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 5 names: ");
        String name[] = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            name[i] = scanner.nextLine();
        }
        System.out.println("You entered the following names:");
        for (int i = 0; i < 5; i++) {
            System.out.print(name[i] + " ");
        }
        scanner.close();
    }
}