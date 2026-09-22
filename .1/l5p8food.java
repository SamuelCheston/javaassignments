import java.util.Scanner;

public class l5p8food {
    public static void main(String[] args) {
        System.out.println("Is it spicy?");
        Scanner scanner = new Scanner(System.in);
        String spicy = scanner.nextLine();
        if (spicy.equalsIgnoreCase("false")) {
            System.out.println("Simple food.");
        } else {
            spicyFood();
        }
    }
    public static void spicyFood() {
        System.out.println("Where is it comes from?");
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.nextLine();
        if (origin.equalsIgnoreCase("India")) {
            System.out.println("Curry.");
        } else if (origin.equalsIgnoreCase("Korea")) {
            System.out.println("Kimchi.");
        } else if (origin.equalsIgnoreCase("China")) {
            System.out.println("Hotpot.");
        }
    }
}
