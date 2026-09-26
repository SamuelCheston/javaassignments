public class StuSys {
  // Global variables from the StuSys class. 
  // (Place your Global Constant variables here)
  public final static int START_ID = 10000;
  public final static int SUCCESS = 1;
  public final static int ERR_LOGIN_FAIL = -1;
  public final static int ERR_PASS_WRONG = -2;
  public final static int ERR_PASS_MISMATCH = -3;
  public final static int ERR_DB_FULL = -4;
  public final static int ERR_POS_INVALID = -5;
  public final static int ERR_GRADE_INVALID = -6;
  public final static int ERR_PASS_LEN = -7;
  
  public final static int GRADE_TBD = -100;
  public final static int GRADE_DROPPED = -200;
  
  // Instance Variables (DO NOT MODIFY)
  private Database db;
  String loginUserId;             /* Keeps track of the currently logged User ID. It will be null when
                                     no one is logged in. */
  int currNewId;                  // The next new user's ID. 
  
  //========== CONSTRUCTOR ==========//
  public StuSys() {
    db = new Database();
    currNewId = START_ID;
  }
  
  //========= PRIVATE METHOD =========//
  // (Write your private methods here)
  // Helper: get raw course entries for an account, each entry like "COURSE_GRADE".
  private String[] getCourseEntries(String id) {
    String all = db.GetAllCourseInfo(id);
    if (all == null) {
      return new String[0];
    }
    String[] parts = all.split(":");
    // filter out empty entries
    int cnt = 0;
    for (int i = 0; i < parts.length; i++) {
      if (!parts[i].equals("")) {
        cnt++;
      }
    }
    String[] res = new String[cnt];
    int idx = 0;
    for (int i = 0; i < parts.length; i++) {
      if (!parts[i].equals("")) {
        res[idx++] = parts[i];
      }
    }
    return res;
  }

  // Helper: parse grade from a course entry
  private int parseGrade(String entry) {
    String[] parts = entry.split("_");
    if (parts.length < 2 || parts[1].equals("")) {
      return GRADE_TBD;
    }
    try {
      return Integer.parseInt(parts[1]);
    } catch (NumberFormatException e) {
      return GRADE_TBD;
    }
  }
  
  
  // Helper: check if grade is valid (0-100)
  private boolean isValidGrade(int grade) {
    if (grade >= 0 && grade <= 100) {
      return true;
    }
    return false;
  }
  
  //========= PUBLIC METHOD =========//
  /* PROVIDED METHOD 
   * Used to import dummy data into the database, so there will 
   * be pre-existing accounts in the database to be used for testing.
   * @param filename - The filename of the textfile that contains all 
   *                   dummy data. */
  public void ImportAcct( String filename ) {
    currNewId += db.ImportAcct( filename, currNewId );
  }
  
  /* Create a new account with given info. It will also info checking
   * @param name       - The name for the account 
   * @param pass       - The password for the account
   * @param retypePass - The retype password 
   * @return           - The status of the account creation process 
   *                     Returns  1, if account is created successfully 
   *                     Returns -3, if password and retype password don't match 
   *                     Returns -4, if number of accounts have reached its limit
   *                     Returns -7, if password is not 5 characters. */
  public int CreateNewAcct(String name, String pass, String retypePass ) {
    // Check if password and retype password match
    if (!pass.equals(retypePass)) {
      return ERR_PASS_MISMATCH;
    }
    // Check if password is 5 characters
    if (pass.length() != 5) {
      return ERR_PASS_LEN;
    }
    
    // Generate ID
    String id = String.valueOf(currNewId);
    
    // Store the new account in the database
    if (db.AddAcct(id, name, pass)) {
      currNewId++;
      return SUCCESS;
    }
    return ERR_DB_FULL;
  }
  
  /* Login a user with the given student ID and password
   * @param id   - The account ID
   * @param pass - The account password 
   * @return     - Returns  1, if login successfully - the ID and password both 
   *                           matches the info in the database.
   *               Returns -1, if account ID not found in the database.
   *               Returns -2, if password associated with the ID is not correct. */
  public int Login(String id, String pass) {
    // Check if the account ID exists in the database
    if (!db.IsAcctExist(id)) {
      return ERR_LOGIN_FAIL;
    }
    // Check if the password is correct
    String storedPass = db.GetAcctPass(id);
    if (!storedPass.equals(pass)) {
      return ERR_PASS_WRONG;
    }
    // set logged in account id
    loginUserId = id;
    return SUCCESS;
  }

  /* Logout the currently logged in student from the system. */
  public void Logout() {
    loginUserId = null;
  }
  
  /* Get the student's name with the given account ID from 
   * the database. 
   * @param id - The account ID
   * @return   - Returns The student name of the account if the ID is found.
   *             Returns null if the ID is not found. */
  public String GetStudentName(String id) {
    if (!db.IsAcctExist(id)) {
      return null;
    }
    return db.GetAcctName(id);
  }
  
  /* Get the number of courses the specified account has 
   * @param id - The account ID
   * @return   - Returns the number of courses the account has. 
   *             Returns -1, if account ID not found in the database. */     
  public int NumCourse(String id) {
    if (!db.IsAcctExist(id)) {
      return -1;
    }
    return getCourseEntries(id).length;
  }   

  /* Get the course's name stored at the specified position in the database
   * @param id  - The account ID
   * @param pos - The pos where the course is stored in the database. 
   *              First course is at pos 0, second is at pos 1, and etc.
   * @return    - Returns the name of the course at pos.
   *              Returns null if account ID not found or course pos is out of range. */   
  public String GetCourseNameAt(String id, int pos) {
    if (!db.IsAcctExist(id)) {
      return null;
    }
    String[] entries = getCourseEntries(id);
    if (pos < 0 || pos >= entries.length) {
      return null;
    }
    String[] parts = entries[pos].split("_");
    if (parts.length > 0) {
      return parts[0];
    }
    return null;
  }
  
  /* Get the course's grade stored at the specified position in the database
   * @param id  - The account ID
   * @param pos - The pos where the course is stored in the database. 
   *              First course is at pos 0, second is at pos 1, etc.
   * @return    - Returns the grade of the course at pos.
   *              Returns -1, if account ID not found in the database.
   *              Returns -5, if pos specified is beyond the range of number of courses */
  public int GetCourseGradeAt(String id, int pos) {
    if (!db.IsAcctExist(id)) {
      return -1;
    }
    String[] entries = getCourseEntries(id);
    if (pos < 0 || pos >= entries.length) {
      return ERR_POS_INVALID;
    }
    return parseGrade(entries[pos]);
  }
  
  /* Get the student's GPA, the overall average of all completed courses.
   * @param id - The account ID
   * @return   - Returns the GPA of the student. 
   *             Returns -1, if account ID not found in the database. 
   *             Returns -8, if there's no courses completed */
  public double GetGPA(String id) {
    if (!db.IsAcctExist(id)) {
      return -1.0;
    }
    String[] entries = getCourseEntries(id);
    int total = 0;
    int completed = 0;
    for (int i = 0; i < entries.length; i++) {
      int g = GetCourseGradeAt(id, i);
      if (g >= 0) {
        total += g;
        completed++;
      }
    }
    if (completed == 0) {
      return -8.0;
    }
    return (double) total / completed;
  }
  
  /* Add a course to the account
   * @param id         - The account ID
   * @param courseName - The course name.
   * @return           - Returns TRUE if successful added the course 
   *                     Returns FALSE if account ID is not found. */
  public boolean AddCourse( String id, String courseName ) {
    // Check if account ID exists
    if (!db.IsAcctExist(id)) {
      return false;
    }
    // Add course to account
    return db.AddCourse(id, courseName);
  }      
  
  /* Drop a course in an account 
   * @param id  - The account ID
   * @param pos - The pos where the course is stored in the database. 
   *              First course is at pos 0, second is at pos 1, etc. 
   * @return    - Returns  1, if successfully dropped the course. 
   *              Returns -1, if account ID not found in the database
   *              Returns -5, if pos specified is beyond the range of number of courses. */
  public int DropCourse( String id, int pos ) {
    if (!db.IsAcctExist(id)) {
      return ERR_LOGIN_FAIL;
    }
    String[] entries = getCourseEntries(id);
    if (pos < 0 || pos >= entries.length) {
      return ERR_POS_INVALID;
    }
    // Set course grade to GRADE_DROPPED
    if (db.UpdateCourseGradeAt(id, pos, GRADE_DROPPED)) {
      return SUCCESS;
    }
    return ERR_LOGIN_FAIL;
  }   
  
  /* Edit a course's grade in an account 
   * @param id      - The account ID
   * @param pos     - The position of the course that is in the database. 
   *                  First course is at pos 0, second is at pos 1, etc. 
   * @param grade   - The new grade for the course
   * @return        - Returns  1, if successfully edited the course 
   *                  Returns -1, if account ID not found in the database
   *                  Returns -5, if pos specified is beyond the range of number of courses
   *                  Returns -6, if grade is not valid (not between 0-100) */   
  public int EditCourse( String id, int pos, int grade ) {
    if (!db.IsAcctExist(id)) {
      return ERR_LOGIN_FAIL;
    }
    if (!isValidGrade(grade)) {
      return ERR_GRADE_INVALID;
    }
    String[] entries = getCourseEntries(id);
    if (pos < 0 || pos >= entries.length) {
      return ERR_POS_INVALID;
    }
    if (db.UpdateCourseGradeAt(id, pos, grade)) {
      return SUCCESS;
    }
    return ERR_LOGIN_FAIL;
  }
  
  /* Change the account's password
   * @param id   - The account ID
   * @param pass - The new password for the account
   * @return     - Returns  1, if successfully changes the password.
   *               Returns -1, if account ID not found in the database.
   *               Returns -2, if password is incorrect.
   *               Returns -3, if password and retype password don't match 
   *               Returns -7, if new password is not 5 characters. */
  public int ChangePassword( String id, String oldPass, String newPass, String retypePass ) {
    if (!db.IsAcctExist(id)) {
      return ERR_LOGIN_FAIL;
    }
    String curr = db.GetAcctPass(id);
    if (!curr.equals(oldPass)) {
      return ERR_PASS_WRONG;
    }
    if (!newPass.equals(retypePass)) {
      return ERR_PASS_MISMATCH;
    }
    if (newPass.length() != 5) {
      return ERR_PASS_LEN;
    }
    if (db.UpdateAcctPass(id, newPass)) {
      return SUCCESS;
    }
    return ERR_LOGIN_FAIL;
  }   
  
  /* PROVIDED METHOD
   * For testing purposes. You may use this method to 
   * see what is inside the database. */
  public void DisplayDatabase() {
    db.DisplayDatabase();
  }
}