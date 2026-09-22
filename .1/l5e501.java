import java.util.Scanner;

public class l5e501 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = input.nextDouble();

        if (radius >= 0) {
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle is: " + area);
        } else {
            System.out.println("Error: Radius cannot be negative.");
        }
    }
}
