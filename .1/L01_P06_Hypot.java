public class L01_P06_Hypot {
  public static void main(String[] args) {

    double adj = 3.0;
    double opp = 4.0;
    double hypotenuse = Math.hypot(adj, opp);
    System.out.println("The hypotenuse of a right triangle with sides " + adj + " and " + opp + " is: " + hypotenuse);

  }
}
