import java.util.Scanner;
public class l5p4age {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age < 20) {
            System.out.println("You are a child.");
        } else if (age >= 20 && age < 65) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a senior.");
        }
    }
}
