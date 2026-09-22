import java.util.Scanner;
public class l7p2rcg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grades[] = new int[5];
        for (int i = 1; i <= grades.length; i++) {
            System.out.println("Enter Grades " + i + " : ");
            grades[i - 1] = scanner.nextInt();
        }
        System.out.println("Which grade to recall : ");
        int recall = scanner.nextInt();
        System.out.println("Grade " + recall + " is : " + grades[recall - 1]);
        scanner.close();
    }
}