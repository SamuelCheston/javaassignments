import java.util.Scanner;
public class KrabApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int menu;
        String[] Description = new String[5];
        int totalTransactions = 0;
        int countofhistory = 0;

        do {
            System.out.println("==================");
            System.out.println("|    KRAB APP    |");
            System.out.println("==================");
            System.out.println("1 - Krab Car");
            System.out.println("2 - Krab Food");
            System.out.println("3 - Info & History");
            System.out.println("4 - Exit");
            System.out.print("Your Option: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    // Krab Car Menu
                    System.out.println("==================");
                    System.out.println("|    KRAB CAR    |");
                    System.out.println("==================");
                    System.out.print("Enter distant (KM): ");
                    double distance = scanner.nextDouble();
                    System.out.print("Enter toll (rm): ");
                    double toll = scanner.nextDouble();

                    // Input validation
                    if (distance < 0 || toll < 0) {
                        System.out.println("WARNING: Invalid distant or toll!");
                        break;
                    }

                    System.out.print("Have " + points + " Krab Points. Use it? (Y/N): ");
                    String usePoints = scanner.next();

                    if (!usePoints.equalsIgnoreCase("Y") && !usePoints.equalsIgnoreCase("N")) {
                        System.out.println("WARNING: Invalid Option!");
                        break;
                    }

                    // Calculation for ride cost
                    double distanceFee = (distance <= 5) ? 5.00 : 6 * Math.sqrt(0.5 * distance - 2) + 5;
                    double pointsDiscount = 0;
                    int pointsEarned = 0;

                    // Apply points discount
                    if (usePoints.equalsIgnoreCase("Y")) {
                        pointsDiscount = (points / 100) * 5.0;
                        points = 0; // All points are consumed
                    }

                    double totalFee = distanceFee + toll - pointsDiscount;
                    if (totalFee < 0) totalFee = 0; // Minimum fee is 0

                    // Earn points if not using discount
                    if (usePoints.equalsIgnoreCase("N")) {
                        pointsEarned = (int) Math.round(totalFee * 10);
                        points += pointsEarned;
                    }

                    // Output display with right-alignment
                    System.out.printf("%-15s : %10.2f\n", "Trip Cost", distanceFee);
                    System.out.printf("%-15s : %10.2f\n", "Toll", toll);
                    if (usePoints.equalsIgnoreCase("Y")) {
                        System.out.printf("%-15s : -%9.2f\n", "Discount", pointsDiscount);
                    }
                    System.out.println("---------------------------");
                    System.out.printf("%-15s : %10.2f\n", "Total", totalFee);
                    System.out.printf("%-15s : %10d\n", "Krab Points Earned", pointsEarned);

                    // Update transaction history (Last 5 records)
                    totalTransactions++;
                    String historyMsg;
                    if (usePoints.equalsIgnoreCase("Y")) {
                        historyMsg = String.format("CAR : Charged %.2f rm, discounted %.2f rm", totalFee, pointsDiscount);
                    } else {
                        historyMsg = String.format("CAR : Charged %.2f rm and earned %d Krab Points", totalFee, pointsEarned);
                    }

                    if (countofhistory < 5) {
                        Description[countofhistory++] = historyMsg;
                    } else {
                        // Shift left to remove oldest and add new to end
                        for (int i = 0; i < 4; i++) {
                            Description[i] = Description[i + 1];
                        }
                        Description[4] = historyMsg;
                    }
                    break;

                case 2:
                    // Krab Food Menu
                    System.out.println("==================");
                    System.out.println("|    KRAB FOOD   |");
                    System.out.println("==================");
                    System.out.print("Enter Food Price : ");
                    double foodPrice = scanner.nextDouble();
                    System.out.print("Enter distant (KM): ");
                    double foodDistance = scanner.nextDouble();

                    // Input validation
                    if (foodDistance < 0 || foodPrice <= 0) {
                        System.out.println("WARNING: Invalid distance or price!");
                        break;
                    }

                    // Calculation for food cost and delivery
                    double foodTax = foodPrice * 0.12;
                    double deliveryFee = 3.75 * foodDistance;
                    double totalFoodFee = foodPrice + foodTax + deliveryFee;
                    int foodPointsEarned = (int) (foodPrice * 3); // Round down to nearest integer
                    points += foodPointsEarned;

                    // Output display
                    System.out.printf("%-15s : %10.2f\n", "Food Cost", foodPrice);
                    System.out.printf("%-15s : %10.2f\n", "Tax", foodTax);
                    System.out.printf("%-15s : %10.2f\n", "Delivery Fee", deliveryFee);
                    System.out.println("---------------------------");
                    System.out.printf("%-15s : %10.2f\n", "Total", totalFoodFee);
                    System.out.printf("%-15s : %10d\n", "Krab Points Earned", foodPointsEarned);

                    // Update transaction history
                    totalTransactions++;
                    String foodHistoryMsg = String.format("FOOD : Charged %.2f rm and earned %d Krab Points", totalFoodFee, foodPointsEarned);

                    if (countofhistory < 5) {
                        Description[countofhistory++] = foodHistoryMsg;
                    } else {
                        for (int i = 0; i < 4; i++) {
                            Description[i] = Description[i + 1];
                        }
                        Description[4] = foodHistoryMsg;
                    }
                    break;

                case 3:
                    // Display User Information and History
                    System.out.println("==================");
                    System.out.println("|    USER INFO   |");
                    System.out.println("==================");
                    System.out.println("Krab Points: " + points);
                    System.out.println();
                    if (countofhistory == 0) {
                        System.out.println("(No history at the moment!)");
                    } else {
                        System.out.printf("%-7s %s\n", "Hist #", "Description");
                        System.out.println("------- --------------------------------------------------");
                        // Print history in reverse order (latest first)
                        for (int i = countofhistory - 1; i >= 0; i--) {
                            int histNum = totalTransactions - (countofhistory - 1 - i);
                            System.out.printf("%-7d %s\n", histNum, Description[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using Kab App");
                    break;

                default:
                    System.out.println("WARNING: Invalid Option!");
                    break;
            }
      } while ( menu != 4 );
      scanner.close();
}
}