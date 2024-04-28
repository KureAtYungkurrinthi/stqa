import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CupTest {
    Cup cup;

    @BeforeEach
    @DisplayName("Set up & test constructor")
    void setUp() {
        cup = new Cup(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Test constructor exception")
    void constructorException(int capacity) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cup = new Cup(capacity));
        assertEquals("Capacity must be positive", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 7})
    @DisplayName("Test fill & getCurrentVolume method")
    void fill(int volume) {
        cup.fill(volume);
        assertEquals(volume, cup.getCurrentVolume());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    @DisplayName("Test fill exception")
    void fillException(int volume) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cup.fill(volume));
        assertEquals(volume < 0 ? "Amount must be non-negative" : "Exceeds cup capacity", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 7})
    @DisplayName("Test empty method")
    void empty(int volume) {
        cup.fill(volume);
        cup.empty();
        assertEquals(0, cup.getCurrentVolume());
    }

    @Test
    @DisplayName("Test getCapacity method")
    void getCapacity() {
        assertEquals(10, cup.getCapacity());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 7})
    @DisplayName("Test isEmpty method")
    void isEmpty(int volume) {
        cup.fill(volume);
        assertEquals(volume == 0, cup.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 7})
    @DisplayName("Test isFull method")
    void isFull(int volume) {
        cup.fill(volume);
        assertEquals(volume == 10, cup.isFull());
    }
}