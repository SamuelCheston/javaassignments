import java.util.Scanner;
public class StuSysMain {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StuSys sys = new StuSys();
    String stuID = "";
    String stuName = "";
    String stuPassword = "";
    int option = 0;

    do {
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
        sc.nextLine(); // Clear buffer
      } else {
        sc.nextLine(); // Clear invalid input
        System.out.println("Invalid input! Please enter a number.");
        continue;
      }

      switch(option){
        case 1:
          // Ask user to create account for new student
          System.out.println("----------------------");
          System.out.println("|   CREATE ACCOUNT   |");
          System.out.println("----------------------");
          System.out.printf("%-20s", "Student ID: ");
          stuID = sc.nextLine();
          System.out.printf("%-20s", "Full Name: ");
          stuName = sc.nextLine();
          System.out.printf("%-20s", "Password: ");
          stuPassword = sc.nextLine();
          System.out.printf("%-20s", "Retype Password: ");
          String retypePassword = sc.nextLine();

          // Pass info to backend
          int result = sys.CreateNewAcct(stuID, stuName, stuPassword, retypePassword);

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
          String loginID = sc.nextLine();
          System.out.printf("%-20s", "Password: ");
          String loginPassword = sc.nextLine();
          
          int loginResult = sys.Login(loginID, loginPassword);
          if(loginResult != 1){
            System.out.println("Invalid login credentials!");
            break;
          }
          else{
            System.out.println("Login success.");
          }

          int option2 = 0;
          do {
            // Get STU details
            String studentName = sys.GetStudentName(loginID);
            double studentgpa = sys.GetGPA(loginID);
            int numCourses = sys.NumCourse(loginID);

            // Display option screen
            System.out.println("====================================================");
            System.out.println("|               CIMP STUNDENT SYSTEM               |");
            System.out.println("|                  OPTION SCREEN                   |");
            System.out.println("|==================================================|");
            System.out.println("|   1. STUDENT DETAIL    |      4.EDIT COURSE GRADE|");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|   2. ADD COURSES       |      5.CHANGE PASSWORD  |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|   3. DROP COURSES      |      6.LOGOUT           |");
            System.out.println("====================================================");
            System.out.println("Pick an option");
            
            if (sc.hasNextInt()) {
              option2 = sc.nextInt();
              sc.nextLine(); // Clear buffer
            } else {
              sc.nextLine();
              System.out.println("Invalid input! Please enter a number.");
              continue;
            }

            switch(option2){
              case 1:
                System.out.println("---------------------------");
                System.out.println("|   Student Detail   |");
                System.out.println("---------------------------");
                System.out.printf("%-20s", "|Student ID");
                System.out.print(":");
                System.out.println(loginID);
                System.out.printf("%-20s", "|Student Name");
                System.out.print(":");
                System.out.println(studentName);
                System.out.printf("%-20s", "|GPA");
                System.out.print(":");
                if (studentgpa >= 0) {
                  System.out.printf("%.2f\n", studentgpa);
                } else {
                  System.out.println("N/A");
                }
                System.out.println("---------------------------");
                System.out.println("");
                System.out.println("---------------------------");
                System.out.println("|   Courses  |    Grades   |");
                System.out.println("---------------------------");
                if (numCourses > 0) {
                  for (int i = 0; i < numCourses; i++) {
                    String cName = sys.GetCourseName(loginID, i);
                    int cGrade = sys.GetCourseGradeAt(loginID, i);
                    System.out.printf("%-20s", cName);
                    System.out.print(":");
                    if (cGrade >= 0) {
                      System.out.printf("%-20d\n", cGrade);
                    } else {
                      System.out.printf("%-20s\n", "N/A");
                    }
                  }
                } else {
                  System.out.println("No course at the moment!");
                }
                break;
              case 2:
                System.out.println("---------------------------");
                System.out.println("Add Courses");
                System.out.println("---------------------------");
                System.out.println("Course to add: ");
                String courseToAdd = sc.nextLine();
                if (sys.AddCourse(loginID, courseToAdd)) {
                  System.out.println("Successful added " + courseToAdd);
                } else {
                  System.out.println("Failed to add course.");
                }
                break;
              case 3:
                System.out.println("---------------------------");
                System.out.println("Drop Courses");
                System.out.println("---------------------------");
                if (numCourses > 0) {
                  for (int i = 0; i < numCourses; i++) {
                    System.out.printf("%d. %s\n", (i+1), sys.GetCourseName(loginID, i));
                  }
                  System.out.println("Select course number to drop: ");
                  int dropPos = sc.nextInt();
                  sc.nextLine();
                  int dResult = sys.DropCourse(loginID, dropPos - 1);
                  if (dResult == 1) {
                    System.out.println("Successfully dropped the course");
                  } else {
                    System.out.println("Failed to drop course. Error code: " + dResult);
                  }
                } else {
                  System.out.println("No course at the moment!");
                }
                break;
              case 4:
                System.out.println("---------------------------");
                System.out.println("Edit Course Grade");
                System.out.println("---------------------------");
                if (numCourses > 0) {
                  for (int i = 0; i < numCourses; i++) {
                    System.out.printf("%d. %s (Grade: %d)\n", (i+1), sys.GetCourseName(loginID, i), sys.GetCourseGradeAt(loginID, i));
                  }
                  System.out.println("Select course number to edit: ");
                  int editPos = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Enter new grade (0-100): ");
                  int newGrade = sc.nextInt();
                  sc.nextLine();
                  int eResult = sys.EditCourse(loginID, editPos - 1, newGrade);
                  if (eResult == 1) {
                    System.out.println("Grade updated successfully.");
                  } else {
                    System.out.println("Failed to update grade. Error code: " + eResult);
                  }
                } else {
                  System.out.println("No course at the moment!");
                }
                break;
              case 5:
                System.out.println("---------------------------");
                System.out.println("Change Password");
                System.out.println("---------------------------");
                System.out.println("Enter old password:");
                String oldPass = sc.nextLine();
                System.out.println("Enter new password:");
                String newPass = sc.nextLine();
                System.out.println("Retype new password:");
                String confirmPass = sc.nextLine();
                int cpResult = sys.ChangePassword(loginID, oldPass, newPass, confirmPass);
                if (cpResult == 1) {
                  System.out.println("Successfully changed the account password");
                } else {
                  System.out.println("Failed to change password. Error code: " + cpResult);
                }
                break;
              case 6:
                sys.Logout();
                System.out.println("Successfully logged out");
                break;
              default:
                System.out.println("Invalid option!");
                break;
            }
          } while (option2 != 6);
          break;

        case 3:
          System.out.println("Exiting System...");
          break;
        default:
          System.out.println("Invalid option!");
          break;
      }
    } while (option != 3);
  }
}
