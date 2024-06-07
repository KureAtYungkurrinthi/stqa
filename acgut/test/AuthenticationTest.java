import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthenticationTest {

    @DisplayName("Test authentication with valid username and password")
    @ParameterizedTest
    @CsvSource({
            "student1, password123",
            "staff1, password123",
    })
    void authenticate(String username, String password) {
        AuthenticationService service = new AuthenticationService();
        User user = service.authenticate(username, password);
        assertNotNull(user);
    }

    @DisplayName("Test authentication with invalid username and password")
    @ParameterizedTest
    @CsvSource({
            "student2, password456",
            "staff1, password456"
    })
    void authenticateInvalid(String username, String password) {
        AuthenticationService service = new AuthenticationService();
        User user = service.authenticate(username, password);
        assertNull(user);
    }
}