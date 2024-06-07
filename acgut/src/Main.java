import java.util.List;
import java.util.Scanner;

public class Main {
    private static AuthenticationService authService = new AuthenticationService();
    private static CourseService courseService = new CourseService();
    private static CalendarService calendarService = new CalendarService();
    private static SubmissionService submissionService = new SubmissionService();
    private static ForumService forumService = new ForumService();
    private static long lastActivityTime;
    private static final long TIMEOUT = 10 * 60 * 1000; // 10 minutes in milliseconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                currentUser = authService.authenticate(username, password);
                if (currentUser == null) {
                    System.out.println("Authentication failed. Try again.");
                    continue;
                } else {
                    resetInactivityTimer();
                }
            }

            currentUser.displayMenu();
            String choice = scanner.nextLine();
            resetInactivityTimer();

            if (choice.equals("7")) {
                currentUser = null;
                System.out.println("Logged out successfully.");
                continue;
            }

            handleUserChoice(currentUser, choice, scanner);
        }
    }

    private static void handleUserChoice(User user, String choice, Scanner scanner) {
        if (user instanceof Student) {
            handleStudentChoice((Student) user, choice, scanner);
        } else if (user instanceof AcademicStaff) {
            handleStaffChoice((AcademicStaff) user, choice, scanner);
        }
    }

    private static void handleStudentChoice(Student student, String choice, Scanner scanner) {
        switch (choice) {
            case "1":
                System.out.println("Enter course name:");
                String courseName = scanner.nextLine();
                CourseMaterial cm = courseService.getCourseMaterial(courseName);
                if (cm != null) {
                    cm.getMaterials().forEach(System.out::println);
                } else {
                    System.out.println("No materials found for this course.");
                }
                break;
            case "2":
                System.out.println("Enter assignment title:");
                String title = scanner.nextLine();
                System.out.println("Enter assignment content:");
                String content = scanner.nextLine();
                Assignment assignment = new Assignment(title, content);
                submissionService.uploadAssignment(student.getUsername(), assignment);
                student.addAssignment(assignment);
                System.out.println("Assignment uploaded successfully.");
                break;
            case "3":
                System.out.println("Enter exam title:");
                String examTitle = scanner.nextLine();
                System.out.println("Enter exam answers:");
                String answers = scanner.nextLine();
                Exam exam = new Exam(examTitle, answers);
                submissionService.submitExam(student.getUsername(), exam);
                student.addExam(exam);
                System.out.println("Exam submitted successfully.");
                break;
            case "4":
                List<Grade> grades = submissionService.getStudentGrades(student.getUsername());
                if (!grades.isEmpty()) {
                    grades.forEach(grade -> System.out.println(grade.getTitle() + ": " + grade.getGrade()));
                } else {
                    System.out.println("No grades available.");
                }
                break;
            case "5":
                calendarService.getEvents().forEach(event ->
                        System.out.println(event.getEventTitle() + " on " + event.getEventDate()));
                break;
            case "6":
                forumService.getPosts().forEach(post ->
                        System.out.println(post.getUsername() + ": " + post.getMessage()));
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void handleStaffChoice(AcademicStaff staff, String choice, Scanner scanner) {
        switch (choice) {
            case "1":
                System.out.println("Enter course name:");
                String courseName = scanner.nextLine();
                System.out.println("Enter material content:");
                String material = scanner.nextLine();
                courseService.uploadCourseMaterial(courseName, material);
                System.out.println("Course material uploaded successfully.");
                break;
            case "2":
                System.out.println("Enter student username:");
                String studentUsername = scanner.nextLine();
                List<Assignment> assignments = submissionService.getStudentAssignments(studentUsername);
                if (!assignments.isEmpty()) {
                    assignments.forEach(assignment -> System.out.println(assignment.getTitle() + ": " + assignment.getContent()));
                } else {
                    System.out.println("No assignments submitted by this student.");
                }
                break;
            case "3":
                System.out.println("Enter student username:");
                studentUsername = scanner.nextLine();
                System.out.println("Enter title to grade:");
                String title = scanner.nextLine();
                System.out.println("Enter grade:");
                String gradeValue = scanner.nextLine();
                Grade grade = new Grade(title, gradeValue);
                submissionService.gradeStudent(studentUsername, grade);
                System.out.println("Grade assigned successfully.");
                break;
            case "4":
                calendarService.getEvents().forEach(event ->
                        System.out.println(event.getEventTitle() + " on " + event.getEventDate()));
                break;
            case "5":
                forumService.getPosts().forEach(post ->
                        System.out.println(post.getUsername() + ": " + post.getMessage()));
                System.out.println("Enter your message:");
                String message = scanner.nextLine();
                ForumPost post = new ForumPost(staff.getUsername(), message);
                forumService.addPost(post);
                System.out.println("Message posted successfully.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void resetInactivityTimer() {
        lastActivityTime = System.currentTimeMillis();
    }

    private static void checkInactivity() {
        if (System.currentTimeMillis() - lastActivityTime > TIMEOUT) {
            System.out.println("Session timed out due to inactivity.");
            System.exit(0);
        }
    }
}
