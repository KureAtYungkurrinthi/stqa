import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTask1 {
    StringList testList;

    @DisplayName("Test add method")
    @BeforeEach
    @Test
    void add() {
        testList = new StringList();
        String[] elements = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
        for (String element : elements) {
            assertTrue(testList.add(element));
        }
    }

    @DisplayName("Test get method")
    @ParameterizedTest
    @CsvSource({
            "0, a",
            "1, b",
            "2, c",
            "3, d",
            "4, e",
            "5, f",
            "6, g",
            "7, h",
            "8, i",
            "9, j",
            "10, k",
            "11, l",
            "12, m",
            "13, n"
    })
    void get(int index, String expected) {
        assertEquals(expected, testList.get(index));
    }

    @DisplayName("Test get invalid index")
    @ParameterizedTest
    @ValueSource(ints = {14, 15, 16, 17, 18})
    void illegalArgumentException(int index) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.get(index));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test toString method")
    @Test
    void testToString() {
        String[] elements = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
        String expected = "Printing List: [";
        for (String element : elements) {
            expected += element + ", ";
        }
        assertEquals(expected + "]", testList.toString());
    }

    @DisplayName("Test empty toString method")
    @Test
    void testEmptyToString() {
        testList = new StringList();
        assertEquals("List is empty: []", testList.toString());
    }
}
