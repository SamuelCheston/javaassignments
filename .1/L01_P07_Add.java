import java.util.Scanner;
public class L01_P07_Add {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double num1, num2;
    System.out.print("Enter the first number: ");
    num1 = input.nextDouble();
    System.out.print("Enter the second number: ");
    num2 = input.nextDouble();
    double sum = num1 + num2;
    System.out.println("The sum of the two numbers is: " + sum);
  }
}
