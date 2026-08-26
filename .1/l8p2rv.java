import java.util.Scanner;
public class l8p2rv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        subp obj = new subp();

        System.out.print("Enter length of rectangle: ");
        int length = scanner.nextInt();

        System.out.print("Enter width of rectangle: ");
        int width = scanner.nextInt();

        int area = obj.CalRectArea(length, width);
        System.out.println("Area of rectangle: " + area);
    }
}
