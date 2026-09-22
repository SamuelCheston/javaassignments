import java.util.Scanner;

public class l6e31 {
    public static void main(String[] args) {
    System.out.println("Enter multiplication table number: ");
    Scanner input = new Scanner(System.in);
    int base = input.nextInt();
    for (int i = 1; i <= 10; i++) {
        System.out.println(base + " * " + i + " = " + (base * i));
    }
    input.close();
    }
}
