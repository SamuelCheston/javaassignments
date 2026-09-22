import java.util.Scanner;
public class l6p3seq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start number: ");
        int n = scanner.nextInt();
        System.out.println("Total number: ");
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            System.out.print(n + " ");
            n += 1;
        }
        scanner.close();
    }
}