import java.util.Scanner;

public class l5e031 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();
        if (num1 % 2 == 0) {
            System.out.println(num1 + " is even.");
        } else {
            System.out.println(num1 + " is odd.");
            
        }
    }
}
