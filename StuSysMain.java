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
    int option = sc.nextInt();

    switch(option){
      case 1:
        // Ask user to create account for new student
        System.out.println("----------------------");
        System.out.println("|   CREATE ACCOUNT   |");
        System.out.println("----------------------");
        System.out.printf("%-20s", "Student ID: ");
        String stuID = sc.next();
        System.out.printf("%-20s", "Full Name: ");
        String stuName = sc.next();
        System.out.printf("%-20s", "Password: ");
        String stuPassword = sc.next();
        System.out.printf("%-20s", "Retype Password: ");
        String retypePassword = sc.next();
        // Check if password matches
        if(!stuPassword.equals(retypePassword)){
          System.out.println("Password do not match!");
          break;
        }
        System.out.println("Successfully created account " + "'" + stuID + "'");

        // Pass account information to database
        
        break;
      case 2:
        System.out.println("----------------------");
        System.out.println("|   LOGIN SCREEN   |");
        System.out.println("----------------------");
        System.out.printf("%-20s", "Student ID: ");
        String loginID = sc.next();
        System.out.printf("%-20s", "Password: ");
        String loginPassword = sc.next();
        if(!loginID.equals(stuID) || !loginPassword.equals(stuPassword)){
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