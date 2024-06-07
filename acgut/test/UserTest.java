import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("Test setter and getter")
    @ParameterizedTest
    @CsvSource({
            "student, password123",
            "staff, password456",
            "!#$%&'(), !#$%&()"
    })
    void user(String username, String password) {
        Student student = new Student(username, password);
        AcademicStaff staff = new AcademicStaff(username, password);

        assertAll("Grouped Assertions of Username and Password",
                () -> assertEquals(username, student.getUsername()),
                () -> assertEquals(password, student.getPassword()),
                () -> assertEquals(username, staff.getUsername()),
                () -> assertEquals(password, staff.getPassword())
        );
    }

    @DisplayName("Test student assignments")
    @Test
    void assignments() {
        Student testStudent = new Student("student", "password");
        testStudent.addAssignment(new Assignment("Assignment 1", "Content 1"));
        testStudent.addAssignment(new Assignment("Assignment 2", "Content 2"));
        testStudent.addAssignment(new Assignment("Assignment 3", "Content 3"));

        assertAll("Grouped Assertions of Student Assignments",
                () -> assertEquals(3, testStudent.getAssignments().size()),
                () -> assertEquals("Assignment 1", testStudent.getAssignments().getFirst().getTitle()),
                () -> assertEquals("Content 2", testStudent.getAssignments().get(1).getContent()),
                () -> assertEquals("Assignment 3", testStudent.getAssignments().get(2).getTitle())
        );
    }

    @DisplayName("Test student exams")
    @Test
    void exams() {
        Student testStudent = new Student("student", "password");
        testStudent.addExam(new Exam("Exam 1", "Questions 1"));
        testStudent.addExam(new Exam("Exam 2", "Questions 2"));
        testStudent.addExam(new Exam("Exam 3", "Questions 3"));

        assertAll("Grouped Assertions of Student Exams",
                () -> assertEquals(3, testStudent.getExams().size()),
                () -> assertEquals("Exam 1", testStudent.getExams().getFirst().getTitle()),
                () -> assertEquals("Questions 2", testStudent.getExams().get(1).getQuestions()),
                () -> assertEquals("Exam 3", testStudent.getExams().get(2).getTitle())
        );
    }

    @DisplayName("Test student grades")
    @Test
    void grades() {
        Student testStudent = new Student("student", "password");
        testStudent.addGrade(new Grade("Grade 1", "A"));
        testStudent.addGrade(new Grade("Grade 2", "B"));
        testStudent.addGrade(new Grade("Grade 3", "C"));

        assertAll("Grouped Assertions of Student Grades",
                () -> assertEquals(3, testStudent.getGrades().size()),
                () -> assertEquals("Grade 1", testStudent.getGrades().getFirst().getTitle()),
                () -> assertEquals("B", testStudent.getGrades().get(1).getGrade()),
                () -> assertEquals("Grade 3", testStudent.getGrades().get(2).getTitle())
        );
    }

    @DisplayName("Distinguish between Student and Academic Staff")
    @Test
    void userClass() {
        User student = new Student("student", "password");
        User academicStaff = new AcademicStaff("staff", "password");

        assertAll("Grouped Assertions of User Type",
                () -> assertInstanceOf(Student.class, student),
                () -> assertFalse(student instanceof AcademicStaff),
                () -> assertInstanceOf(AcademicStaff.class, academicStaff),
                () -> assertFalse(academicStaff instanceof Student)
        );
    }

    @DisplayName("Test display menu")
    @Test
    void displayMenu() {
        Student student = new Student("student", "password");
        AcademicStaff academicStaff = new AcademicStaff("staff", "password");

        assertAll("Grouped Assertions of Display Menu",
                () -> assertDoesNotThrow(student::displayMenu),
                () -> assertDoesNotThrow(academicStaff::displayMenu)
        );
    }
}