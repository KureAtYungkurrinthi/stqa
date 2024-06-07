import java.util.ArrayList;
import java.util.List;

class CalendarEvent {
    private String eventTitle;
    private String eventDate; // Use proper date type in real application

    public CalendarEvent(String eventTitle, String eventDate) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }
}

class CalendarService {
    private List<CalendarEvent> events;

    public CalendarService() {
        events = new ArrayList<>();
        // Add some dummy events
        events.add(new CalendarEvent("Assignment 1 Due", "2024-06-15"));
        events.add(new CalendarEvent("Midterm Exam", "2024-07-01"));
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }
}
