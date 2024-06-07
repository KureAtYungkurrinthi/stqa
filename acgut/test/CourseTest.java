import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {
    @DisplayName("Test Upload to Existing Course")
    @Test
    void courseService() {
        CourseService courseService = new CourseService();

        String courseMaterial = "Lecture 3: Data Structures";
        courseService.uploadCourseMaterial("CS101", courseMaterial);

        assertAll("Course Service",
                () -> assertEquals("CS101", courseService.getCourseMaterial("CS101").getCourseName()),
                () -> assertEquals(3, courseService.getCourseMaterial("CS101").getMaterials().size()),
                () -> assertEquals(courseMaterial, courseService.getCourseMaterial("CS101").getMaterials().getLast())
        );
    }

    @DisplayName("Test Upload to Non-existed Course")
    @Test
    void courseServiceInvalid() {
        CourseService courseService = new CourseService();

        String courseMaterial = "Lecture 3: Data Structures";
        courseService.uploadCourseMaterial("CS102", courseMaterial);

        assertAll("Course Service",
                () -> assertEquals("CS102", courseService.getCourseMaterial("CS102").getCourseName()),
                () -> assertEquals(1, courseService.getCourseMaterial("CS102").getMaterials().size()),
                () -> assertEquals(courseMaterial, courseService.getCourseMaterial("CS102").getMaterials().getLast())
        );
    }
}