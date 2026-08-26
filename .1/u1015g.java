import java.util.Scanner;

public class u1015g {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter 5 grades: ");
            System.out.print("First grade: ");
            int grade1 = input.nextInt();
            System.out.print("Second grade: ");
            int grade2 = input.nextInt();
            System.out.print("Third grade: ");
            int grade3 = input.nextInt();
            System.out.print("Fourth grade: ");
            int grade4 = input.nextInt();
            System.out.print("Fifth grade: ");
            int grade5 = input.nextInt();

            double average = (grade1 + grade2 + grade3 + grade4 + grade5) / 5.0;
            System.out.println("The average of the grades is: " + average);
        }
    }
}
