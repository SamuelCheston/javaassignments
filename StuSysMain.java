import java.util.Scanner;
public class StuSysMain {
  
  public static void main(String[] args) {
    System.out.println("======================================");
    System.out.println("|   WELCOME TO CIMP STUNDENT SYSTEM   |");
    System.out.println("======================================");
    System.out.println("1. New Student");
    System.out.println("2. Returning Student");
    System.out.println("3. Exit System");
    System.out.println("Pick an option");
    System.out.println("======================================");
    Scanner sc = new Scanner(System.in);
    // declare student credentials here so they are visible to all cases
    String stuID = "";
    String stuName = "";
    String stuPassword = "";
    int option = sc.nextInt();

    switch(option){
      case 1:
        // Ask user to create account for new student
        System.out.println("----------------------");
        System.out.println("|   CREATE ACCOUNT   |");
        System.out.println("----------------------");
        System.out.printf("%-20s", "Student ID: ");
        stuID = sc.next();
        System.out.printf("%-20s", "Full Name: ");
        stuName = sc.next();
        System.out.printf("%-20s", "Password: ");
        stuPassword = sc.next();
        System.out.printf("%-20s", "Retype Password: ");
        String retypePassword = sc.next();

        // Pass info to backend
        StuSys CNewAcct = new StuSys();
        int result = CNewAcct.CreateNewAcct(stuName, stuPassword, retypePassword);

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
        StuSys CLogin = new StuSys();
        int loginResult = CLogin.Login(loginID, loginPassword);
        if(loginResult != 1){
          System.out.println("Invalid login credentials!");
        }
        else{
          System.out.println("Login successful!");
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