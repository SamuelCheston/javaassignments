import java.util.Scanner;
public class StuSysMain {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StuSys system = new StuSys();
    
    // Import existing accounts at startup
    system.ImportAcct("AcctInfo.txt");

    int option = 0;
    while (option != 3) {
      System.out.println("======================================");
      System.out.println("|   WELCOME TO CIMP STUNDENT SYSTEM   |");
      System.out.println("======================================");
      System.out.println("1. New Student");
      System.out.println("2. Returning Student");
      System.out.println("3. Exit System");
      System.out.println("Pick an option");
      System.out.println("======================================");
      
      if (sc.hasNextInt()) {
        option = sc.nextInt();
      } else {
        sc.next(); // clear invalid input
        option = 0;
      }

      switch(option){
        case 1:
          // Ask user to create account for new student
          System.out.println("----------------------");
          System.out.println("|   CREATE ACCOUNT   |");
          System.out.println("----------------------");
          // Note: Student ID is automatically assigned by the system
          System.out.printf("%-20s", "Full Name: ");
          String stuName = sc.next();
          System.out.printf("%-20s", "Password: ");
          String stuPassword = sc.next();
          System.out.printf("%-20s", "Retype Password: ");
          String retypePassword = sc.next();

          // Pass info to backend using the shared system instance
          int result = system.CreateNewAcct(stuName, stuPassword, retypePassword);

          // Check if account creation was successful
          if (result == 1) {
            System.out.println("Account created successfully!");
          } else {
            System.out.println("Failed to create account. Error code: " + result);
          }
          break;

        case 2:
          System.out.println("----------------------");
          System.out.println("|   LOGIN SCREEN   |");
          System.out.println("----------------------");
          System.out.printf("%-20s", "Student ID: ");
          String loginID = sc.next();
          System.out.printf("%-20s", "Password: ");
          String loginPassword = sc.next();
          
          // Use the shared system instance for login
          int loginResult = system.Login(loginID, loginPassword);
          if(loginResult != 1){
            System.out.println("Invalid login credentials! (Error code: " + loginResult + ")");
          }
          else{
            System.out.println("Login success!");
          }
          break;

        case 3:
          System.out.println("Exit System");
          break;

        default:
          System.out.println("Invalid option");
          break;
      }
    }
  }
}