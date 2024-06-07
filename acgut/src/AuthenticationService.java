import java.util.HashMap;
import java.util.Map;

class AuthenticationService {
    private Map<String, User> users;

    public AuthenticationService() {
        users = new HashMap<>();
        // Preload with some dummy data
        users.put("student1", new Student("student1", "password123"));
        users.put("staff1", new AcademicStaff("staff1", "password123"));
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
