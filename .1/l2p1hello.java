import java.util.Scanner;

public class l2p1hello {
  public static void main(String[] args) {
    Scanner nameScanner = new Scanner(System.in);
    Scanner ageScanner = new Scanner(System.in);
    String name;
    String age;
    System.out.print("Enter your name: ");
    name = nameScanner.nextLine();
    System.out.print("Enter your age: ");
    age = ageScanner.nextLine();
    System.out.println("Hello, " + name + "! You are " + age + " years old.");
  }
}
