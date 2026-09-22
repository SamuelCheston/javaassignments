import java.util.Scanner;

public class l5e21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();
        boolean isGreater = num1 > 10;
        System.out.println("Is " + num1 + " greater than 10? " + isGreater);
        System.out.print("Enter the second number: ");
    }
}
