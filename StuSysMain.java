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
          break;
        }
        else{
          System.out.println("Login success.");
        }
        // Get STU details
        int studentID = Integer.parseInt(loginID);
        String studentName = CLogin.GetStudentName(loginID);
        double studentgpa = CLogin.GetGPA(loginID);
        int numCourses = CLogin.NumCourse(loginID);
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
        int option2 = sc.nextInt();
        switch(option2){
          case 1:
            System.out.println("---------------------------");
            System.out.println("|   Student Detail   |");
            System.out.println("---------------------------");
            System.out.printf("%-20s", "|Student ID");
            System.out.print(":");
            System.out.print(studentID);
            System.out.printf("%-20s", "|Student Name");
            System.out.print(":");
            System.out.printf("%-20s", studentName);
            System.out.printf("%-20s", "|GPA");
            System.out.print(":");
            System.out.printf("%.2f", studentgpa);
            System.out.println("---------------------------");
            System.out.println("");
            System.out.println("---------------------------");
            System.out.println("|   Courses  |    Grades   |");
            System.out.println("---------------------------");
            // Check if student has courses
            if (numCourses > 0) {
              for (int i = 0; i < numCourses; i++) {
                String courseName = CLogin.GetCourseName(loginID, i);
                String courseGrade = CLogin.GetCourseGrade(loginID, i);
                System.out.printf("%-20s", courseName);
                System.out.print(":");
                System.out.printf("%-20s", courseGrade);
                System.out.println("");
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
            String courseToAdd = sc.next();
            int addResult = CLogin.AddCourse(loginID, courseToAdd);
            if (addResult == 1) {
              System.out.println("Successful added " + courseToAdd );
            } else {
              System.out.println("Failed to add course. Error code: " + addResult);
            }

            break;
          case 3:
            System.out.println("---------------------------");
            System.out.println("Drop Courses");
            System.out.println("---------------------------");

            // List current courses before dropping
            if (numCourses > 0) {
              for (int i = 0; i < numCourses; i++) {
                String courseName = CLogin.GetCourseName(loginID, i);
                System.out.printf("%-20s", courseName);
                System.out.println("");
              }
            } else {
              System.out.println("No course at the moment!");
              break;
            }
            System.out.println("Select course number to drop: ");
            String courseToDrop = sc.next();
            int dropResult = CLogin.DropCourse(loginID, courseToDrop);
            if (dropResult == 1) {
              System.out.println("Successfully dropped the course");
            } else {
              System.out.println("Failed to drop course. Error code: " + dropResult);
            }
            break;
          case 4:
            System.out.println("---------------------------");
            System.out.println("Edit Course Grade");
            System.out.println("---------------------------"); 
            // List current courses before editing
            if (numCourses > 0) {
              System.out.println("YOUR CURRENT COURSES:");
              for (int i = 0; i < numCourses; i++) {
                String courseName = CLogin.GetCourseName(loginID, i);
                String courseGrade = CLogin.GetCourseGrade(loginID, i);
                System.out.printf("%-20s", courseName);
                System.out.print(":");
                System.out.printf("%-20s", courseGrade);
                System.out.println("");
              }
            } else {
              System.out.println("No course at the moment!");
              break;
            }
            break;
          case 5:
            System.out.println("Change Password");
            break;
          case 6:
            System.out.println("Logout");
            break;
          default:
            System.out.println("Invalid option");
            break;
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