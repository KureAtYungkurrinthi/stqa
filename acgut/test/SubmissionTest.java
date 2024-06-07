import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionTest {

    @DisplayName("Test for Assignments")
    @Test
    void assignment() {
        SubmissionService submissionService = new SubmissionService();
        submissionService.uploadAssignment("student1", new Assignment("Assignment 1", "Content 1"));
        submissionService.uploadAssignment("student1", new Assignment("Assignment 2", "Content 2"));
        submissionService.uploadAssignment("student2", new Assignment("Assignment 3", "Content 3"));
        assertAll("Assignment Submission Test",
                () -> assertEquals(2, submissionService.getStudentAssignments("student1").size()),
                () -> assertEquals(1, submissionService.getStudentAssignments("student2").size()),
                () -> assertEquals("Assignment 1", submissionService.getStudentAssignments("student1").getFirst().getTitle()),
                () -> assertEquals("Content 1", submissionService.getStudentAssignments("student1").getFirst().getContent()),
                () -> assertEquals("Assignment 2", submissionService.getStudentAssignments("student1").getLast().getTitle()),
                () -> assertEquals("Content 2", submissionService.getStudentAssignments("student1").getLast().getContent()),
                () -> assertEquals("Assignment 3", submissionService.getStudentAssignments("student2").getFirst().getTitle()),
                () -> assertEquals("Content 3", submissionService.getStudentAssignments("student2").getFirst().getContent())
        );
    }

    @DisplayName("Test for Exams")
    @Test
    void exam() {
        SubmissionService submissionService = new SubmissionService();
        submissionService.submitExam("student1", new Exam("Exam 1", "Questions 1"));
        submissionService.submitExam("student1", new Exam("Exam 2", "Questions 2"));
        submissionService.submitExam("student2", new Exam("Exam 3", "Questions 3"));
        assertAll("Exam Submission Test",
                () -> assertEquals(2, submissionService.getStudentExams("student1").size()),
                () -> assertEquals(1, submissionService.getStudentExams("student2").size()),
                () -> assertEquals("Exam 1", submissionService.getStudentExams("student1").getFirst().getTitle()),
                () -> assertEquals("Questions 1", submissionService.getStudentExams("student1").getFirst().getQuestions()),
                () -> assertEquals("Exam 2", submissionService.getStudentExams("student1").getLast().getTitle()),
                () -> assertEquals("Questions 2", submissionService.getStudentExams("student1").getLast().getQuestions()),
                () -> assertEquals("Exam 3", submissionService.getStudentExams("student2").getFirst().getTitle()),
                () -> assertEquals("Questions 3", submissionService.getStudentExams("student2").getFirst().getQuestions())
        );
    }

    @DisplayName("Test for Grades")
    @Test
    void grade() {
        SubmissionService submissionService = new SubmissionService();
        submissionService.gradeStudent("student1", new Grade("Exam 1", "A"));
        submissionService.gradeStudent("student1", new Grade("Exam 2", "B"));
        submissionService.gradeStudent("student2", new Grade("Exam 3", "C"));
        assertAll("Grade Submission Test",
                () -> assertEquals(2, submissionService.getStudentGrades("student1").size()),
                () -> assertEquals(1, submissionService.getStudentGrades("student2").size()),
                () -> assertEquals("Exam 1", submissionService.getStudentGrades("student1").getFirst().getTitle()),
                () -> assertEquals("A", submissionService.getStudentGrades("student1").getFirst().getGrade()),
                () -> assertEquals("Exam 2", submissionService.getStudentGrades("student1").getLast().getTitle()),
                () -> assertEquals("B", submissionService.getStudentGrades("student1").getLast().getGrade()),
                () -> assertEquals("Exam 3", submissionService.getStudentGrades("student2").getFirst().getTitle()),
                () -> assertEquals("C", submissionService.getStudentGrades("student2").getFirst().getGrade())
        );
    }
}