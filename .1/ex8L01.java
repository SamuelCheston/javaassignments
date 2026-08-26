import java.util.Scanner;

public class ex8L01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double radius;
    System.out.print("Enter the radius of the circle: ");
    radius = input.nextDouble();
    double area = 3.14 * Math.pow(radius, 2);
    System.out.println("The area of the circle is: " + area);
  }
}
