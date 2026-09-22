import java.util.Scanner;

public class l3e3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double deci = sc.nextDouble();
        System.out.print("Enter a text: ");
        String text = sc.next();

        System.out.printf("The number is: %.2f\n", deci);
        System.out.printf("The text is: %s\n", text);
    }

}
