import java.util.ArrayList;
import java.util.List;

abstract class User {
    private String username;
    private String password;
    // Constructor, getters, and setters

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void displayMenu();
}

class Student extends User {
    private List<Assignment> assignments;
    private List<Exam> exams;
    private List<Grade> grades;

    public Student(String username, String password) {
        super(username, password);
        this.assignments = new ArrayList<>();
        this.exams = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    @Override
    public void displayMenu() {
        System.out.println("1. View Course Material");
        System.out.println("2. Upload Assignment");
        System.out.println("3. Take Online Exam");
        System.out.println("4. Check Grades");
        System.out.println("5. View Academic Calendar");
        System.out.println("6. Access Discussion Forum");
        System.out.println("7. Logout");
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }
}

class AcademicStaff extends User {
    public AcademicStaff(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Upload Course Material");
        System.out.println("2. View Student Submissions");
        System.out.println("3. Grade Assignments/Exams");
        System.out.println("4. View Academic Calendar");
        System.out.println("5. Access Discussion Forum");
        System.out.println("6. Logout");
    }
}
