import java.util.Scanner;
public class krab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;



        System.out.println("==============");
        System.out.println("  Krab App");
        System.out.println("==============");
        System.out.println("1- Krab Car");
        System.out.println("2- Krab Food");
        System.out.println("3- Info & History");
        System.out.println("4- Exit");
        System.out.print("Choose Menu : ");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                double distancefee = 0;
                double totalfee = 0;
                System.out.println("Krab Car");
                System.out.print("Enter distance (KM) : ");
                int distance = scanner.nextInt();
                System.out.print("Enter Toll (RM) : ");
                double toll = scanner.nextDouble();
                System.out.print("Have " + points + " Krab points, use points? (Y/N) : ");
                String usePoints = scanner.next();
                if ( usePoints.equals("Y") || usePoints.equals("y") ) {
                    int pointsdiscount = (int)points / 10;

                    // Calculate distance fee
                    if ( distance <= 5 ) {
                         distancefee = 5;
                    } else {
                     distancefee =  6 * Math.pow(0.5 * distance - 2, 0.5) + 5;
                }
                // Compare discount with total fee
                if ( pointsdiscount >= distancefee + toll ) {
                    totalfee = 0;
                    points = 0;
                } else {
                    totalfee = distancefee + toll - pointsdiscount;
                }
                // Calculate points earned
                if (usePoints.equals("N") || usePoints.equals("n")) {
                    points += (int)totalfee / 10;
                }
                System.out.println("Trip cost: " + distancefee);
                System.out.println("Toll cost: " + toll);
                System.out.println("Points discount: " + pointsdiscount);
                System.out.println("Total fee: " + totalfee);
                break;
            case 2:
                System.out.println("Krab Food");
                break;
            case 3:
                System.out.println("Info & History");
                break;
            case 4:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid Menu");
        }
    }
}
