import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarTest {

    @DisplayName("Test Calendar Service")
    @ParameterizedTest
    @CsvSource({
        "Assignment 1 Due, 2024-06-15",
        "Midterm Exam, 2024-07-01",
        "Assignment 2 Due, 2024-07-15",
        "Final Exam, 2024-07-30"
    })
    void calendarService(String eventTitle, String eventDate) {
        CalendarService calendarService = new CalendarService();
        calendarService.addEvent(new CalendarEvent(eventTitle, eventDate));

        assertAll("Test Calendar Service",
            () -> assertEquals(3, calendarService.getEvents().size()),
            () -> assertEquals("Assignment 1 Due", calendarService.getEvents().getFirst().getEventTitle()),
            () -> assertEquals("2024-06-15", calendarService.getEvents().getFirst().getEventDate()),
            () -> assertEquals(eventTitle, calendarService.getEvents().getLast().getEventTitle()),
            () -> assertEquals(eventDate, calendarService.getEvents().getLast().getEventDate())
        );
    }
}