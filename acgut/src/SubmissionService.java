import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Assignment {
    private String title;
    private String content;

    public Assignment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

class Exam {
    private String title;
    private String questions;

    public Exam(String title, String questions) {
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestions() {
        return questions;
    }
}

class Grade {
    private String title;
    private String grade;

    public Grade(String title, String grade) {
        this.title = title;
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public String getGrade() {
        return grade;
    }
}

class SubmissionService {
    private Map<String, List<Assignment>> studentAssignments;
    private Map<String, List<Exam>> studentExams;
    private Map<String, List<Grade>> studentGrades;

    public SubmissionService() {
        studentAssignments = new HashMap<>();
        studentExams = new HashMap<>();
        studentGrades = new HashMap<>();
    }

    public void uploadAssignment(String studentUsername, Assignment assignment) {
        studentAssignments.computeIfAbsent(studentUsername, k -> new ArrayList<>()).add(assignment);
    }

    public void submitExam(String studentUsername, Exam exam) {
        studentExams.computeIfAbsent(studentUsername, k -> new ArrayList<>()).add(exam);
    }

    public void gradeStudent(String studentUsername, Grade grade) {
        studentGrades.computeIfAbsent(studentUsername, k -> new ArrayList<>()).add(grade);
    }

    public List<Assignment> getStudentAssignments(String studentUsername) {
        return studentAssignments.getOrDefault(studentUsername, new ArrayList<>());
    }

    public List<Exam> getStudentExams(String studentUsername) {
        return studentExams.getOrDefault(studentUsername, new ArrayList<>());
    }

    public List<Grade> getStudentGrades(String studentUsername) {
        return studentGrades.getOrDefault(studentUsername, new ArrayList<>());
    }
}
