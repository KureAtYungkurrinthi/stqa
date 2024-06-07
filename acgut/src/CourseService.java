import java.util.HashMap;
import java.util.Map;

class CourseService {
    private Map<String, CourseMaterial> courses;

    public CourseService() {
        courses = new HashMap<>();
        // Initialize with some dummy data
        CourseMaterial cm = new CourseMaterial("CS101");
        cm.addMaterial("Lecture 1: Introduction to Java");
        cm.addMaterial("Lecture 2: Object-Oriented Programming");
        courses.put("CS101", cm);
    }

    public CourseMaterial getCourseMaterial(String courseName) {
        return courses.get(courseName);
    }

    public void uploadCourseMaterial(String courseName, String material) {
        CourseMaterial courseMaterial = courses.get(courseName);
        if (courseMaterial == null) {
            courseMaterial = new CourseMaterial(courseName);
            courses.put(courseName, courseMaterial);
        }
        courseMaterial.addMaterial(material);
    }
}
