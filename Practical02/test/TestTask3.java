import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTask3 {
    StringList testList;

    @BeforeEach
    void setUp() {
        testList = new StringList(5);
        String[] elements = {"a", "b", "c", "d"};
        for (String element : elements) {
            testList.add(element);
        }
    }

    @DisplayName("Test add element by index")
    @ParameterizedTest
    @CsvSource({"0, e, a", "1, f, b", "2, g, c", "3, h, d"})
    void addIndex(int index, String element, String expected) {
        testList.add(4, "z");
        testList.add(index, element);
        assertEquals(6, testList.size());
        assertEquals(element, testList.get(index));
        assertEquals(expected, testList.get(index + 1));
    }

    @DisplayName("Test add IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(ints = {5, -1})
    void addIllegalArgumentException(int index) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.add(index, "z"));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test remove by index")
    @ParameterizedTest
    @CsvSource({"0, a", "1, b", "2, c", "3, d"})
    void removeIndex(int index, String expected) {
        assertEquals(expected, testList.remove(index));
        assertEquals(3, testList.size());
    }

    @DisplayName("Test remove IllegalArgumentException by index")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void removeIllegalArgumentException(int index) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.remove(index));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test remove by element")
    @ParameterizedTest
    @CsvSource({"a, true", "b, true", "c, true", "d, true", "e, false", "f, false"})
    void removeElement(String element, boolean expected) {
        assertEquals(expected, testList.remove(element));
    }

    @DisplayName("Test clear and isEmpty method")
    @Test
    void clearIsEmpty() {
        testList.clear();
        assertTrue(testList.isEmpty());
    }
}
