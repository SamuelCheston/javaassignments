# ICS4U: Unit 2 - Modular Programming
## Assignment 2 – Student Management System

### 1. General Info
You are to help CIMP to write Student Management System (StuSys). The system will used by guidance to help keep track of student’s marks and other information. The system has the following requirements:
* Has a login system, where each student has a login password.
* Has a create new student function, for new students to be entered into the system.
* Once logged into a student’s account, she/he has the following options:
    * Student detail info
    * Add a course
    * Drop a course
    * Edit a course grade
    * Change password
    * Logout

---

### 2. Program Flow
**[图片描述：程序流程图]**
该流程图描述了系统的逻辑结构：
1. **开始 (Start of Program)**：进入主菜单。
2. **主菜单 (Main Menu)**：
   - 选项 1：**新建学生 (New Student Screen)** -> 成功后进入 **创建账户 (Create new account)** -> 返回主菜单。
   - 选项 2：**登录界面 (Login Screen)** -> 验证通过后进入 **返回学生菜单 (Returning Students Menu)**。若失败则返回主菜单。
   - 选项 3：**退出程序 (End of Program)**。
3. **返回学生菜单 (Returning Students Menu)**：
   - **学生详情 (Student Detail Screen)**
   - **添加课程 (Add Course Screen)**
   - **删除课程 (Drop Course Screen)**
   - **编辑课程成绩 (Edit Course Screen)**
   - **更改密码 (Change Password Screen)**
   - **注销 (Logout)** -> 返回主菜单。

---

### 3. UML Diagram
**[图片描述：程序 UML 类图]**
程序由三个主要类组成：
1. **StuSysMain**
   - 包含 `main(args: String[]): void` 方法。
   - 作为程序的入口点。
2. **StuSys**
   - **属性**：
     - `db: Database`
     - `loginUserId: String`
     - `currNewId: int`
   - **方法**：
     - `StuSys()` (构造函数)
     - `ImportAcct(filename: String): void`
     - `CreateNewAcct(name: String, pass: String, retypePass: String): int`
     - `Login(id: String, pass: String): int`
     - `Logout(): void`
     - `GetStudentName(id: String): String`
     - `NumCourse(id: String): int`
     - `GetCourseNameAt(id: String, pos: int): String`
     - `GetCourseGradeAt(id: String, pos: int): int`
     - `GetGPA(id: String): double`
     - `AddCourse(id: String, courseName: String): boolean`
     - `DropCourse(id: String, pos: int): int`
     - `EditCourse(id: String, pos: int, grade: int): int`
     - `ChangePassword(id: String, oldPass: String, newPass: String, retypePass: String): int`
     - `DisplayDatabase(): void`
3. **Database**
   - **常量**：`DEFAULT_NUM_ACCOUNT`, `ARRAY_ID_POS` 等。
   - **属性**：`allAcct: String[]`, `numAcct: int`。
   - **方法**：包含各种数据库操作方法（如 `AddCourse`, `GetAcctPass` 等）。

---

### 4. User Interface
**[图片描述：界面截图序列]**

#### a) Main Screen
显示欢迎信息和三个选项：
1. New Student
2. Returning Student
3. Exit System
输入提示：`Pick an option:`

#### b) New Student Screen
输入学生姓名、密码和重复密码。成功后显示：`Successfully created account '10004'`。

#### c) Login Screen & Returning Student Menu
输入 Student ID 和 Password。登录成功后进入选项屏幕：
- 1. STUDENT DETAIL | 4. EDIT COURSE GRADE
- 2. ADD COURSES | 5. CHANGE PASSWORD
- 3. DROP COURSES | 6. LOGOUT

#### d) & e) Student Detail Screen
显示学生 ID、姓名和 GPA。
- 如果没有课程，GPA 显示 `N/A`，下方显示 `No course at the moment!`。
- 如果有课程，显示课程列表和对应成绩。
  - GPA 只计算已完成课程的平均分。
  - 成绩为 `TBD`（进行中）或 `DROPPED`（已删除）的不计入 GPA。

#### f) Add Course Screen
提示输入课程代码（如 `ICS4U`）。添加后在详情页显示，成绩初始为 `TBD`。

#### g) Drop Course Screen
显示当前课程列表，提示选择要删除的课程编号。删除后详情页对应成绩显示为 `DROPPED`，GPA 会重新计算并忽略该课程。

#### h) Edit Course Screen
显示当前课程及成绩，提示选择课程编号并输入新成绩（0-100）。

#### i) Change Password Screen
提示输入旧密码、新密码和确认新密码。

#### j) & k) Logout & Exit
退出登录返回主菜单，或直接退出程序显示 `System is shutting down.`。

---

### 5. How Info is Stored in the Database & Importing Text File
数据从 `AcctInfo.txt` 导入，列以冒号 `:` 分隔。

| 列号 | 项目 | 特别说明 |
| :--- | :--- | :--- |
| 1 | Account Name | |
| 2 | Account Password | 必须是 5 位字符/数字 |
| 3 及以后 | Course Info | 每个课程包含课程代码和成绩，以下划线 `_` 分隔。例如：`CourseCode1_Grade1` |

**数据库存储格式：**
`[Account ID]:[Student Name]:[Password]:[CourseCode1_Grade1]:[CourseCode2_Grade2]: ... :[CourseCodeN_GradeN]`

**注意事项：**
- Account ID 从 10000 开始递增。
- 密码必须恰好 5 位。
- 成绩为整数。
- `-100` 表示进行中，显示为 `TBD`。
- `-200` 表示已删除，显示为 `DROPPED`。

---

### 6. Requirements
- 不得更改 `Database` 类。
- 必须使用 `Database` 类存储和访问数据。
- 必须遵循程序流程图和 UML 图。
- 不得创建额外的类或额外的公共方法（除了辅助方法）。
- 每个类必须在独立文件中。
- 仅使用 Unit 1 和 Unit 2 教授的内容（禁用 ArrayList 等）。
- 必须遵循前端与后端分离的设计。

---

### 7. Error Checking
- 检查密码是否为 5 位。
- 检查新密码与重复密码是否匹配。
- 检查菜单选项输入的有效性。
- 检查成绩值是否有效（0-100）。
- 假设输入的类型始终正确（例如预期 int 时不会输入 String）。

---

### 8. Provided Templates and Files to Submit
- **提供的文件**：`Database.java`, `StuSys.java`, `StuSysMain.java`, `AcctInfo.txt`。
- **提交的文件**：`StuSysMain.java`, `StuSys.java`。
- **禁止提交**：`Database.java`, `AcctInfo.txt`, `.class` 文件等。

---

### 9. Note
- 教师示例代码总计约 605 行（`StuSys.java` 303 行，`StuSysMain.java` 302 行）。
- 模板已有 161 行，学生需编写约 444 行代码。
- 严禁抄袭代码，系统会进行相似度检查。

---

### 10. Marking Scheme: Checklist
**[图片描述：评分标准表格]**
- **Knowledge (16分)**：正确使用方法、类、对象，正确显示信息，循环逻辑正确。
- **Application (45分)**：各功能方法（Login, Logout, AddCourse 等）正常工作。
- **Thinking (24分)**：全局常量（最少5个）、辅助方法（最少2个）、输入验证、前后端设计、遵循 UML。
- **Communication (20分)**：命名规范、注释充分、排版整洁、UI 格式正确、警告信息清晰。
