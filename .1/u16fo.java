import java.util.Scanner;

public class u16fo {
    public static void main(String[] args) {
        System.out.println("Menu");
        System.out.println("1) juice, muffin, coffee");
        System.out.println("2) cereal, toast, milk");
        System.out.println("3) egg, toast, coffee");
        System.out.println("4) banana, granola, milk");
        System.out.println("5) grapefruit, bacon, eggs, coffee");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice (1-5): ");
        int choice = scanner.nextInt();
        double total = prices(choice);
        System.out.println("Total: $" + total);
    }
    public static double prices(int choice) {
        double price1 = 2.5;
        double price2 = 3.0;
        double price3 = 3.5;
        double price4 = 5.0;
        switch (choice) {
            case 1:
                return price1;
            case 2:
                return price2;
            case 3:
                return price3;
            case 4:
                return price4;
            default:
                System.out.println("Invalid choice.");
                return 0.0;
        }
    }
}
