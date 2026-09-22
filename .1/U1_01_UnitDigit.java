import java.util.Scanner;

public class U1_01_UnitDigit {
  public static void main(String[] args) {
    System.out.print("Enter a number: ");
    Scanner intinput = new Scanner(System.in);
    int number = intinput.nextInt();
    int unitDigit = number % 10;

    System.out.println("The unit digit of " + number + " is: " + unitDigit);
  }
}
