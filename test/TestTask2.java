import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTask2 {
    StringList testList;

    @BeforeEach
    void setUp() {
        testList = new StringList();
        String[] elements = {"a", "b", "c", "d"};
        for (String element : elements) {
            testList.add(element);
        }
    }

    @DisplayName("Test contains method")
    @ParameterizedTest
    @CsvSource({
            "a, true",
            "b, true",
            "c, true",
            "d, true",
            "e, false",
            "f, false",
            "g, false",
            "h, false"
    })
    void contains(String element, boolean expected) {
        assertEquals(expected, testList.contains(element));
    }

    @DisplayName("Test indexOf index")
    @ParameterizedTest
    @CsvSource({
            "a, 0",
            "b, 1",
            "c, 2",
            "d, 3",
            "e, -1",
            "f, -1",
            "g, -1",
            "h, -1"
    })
    void indexOf(String element, int expected) {
        assertEquals(expected, testList.indexOf(element));
    }

    @DisplayName("Test set method")
    @ParameterizedTest
    @CsvSource({
            "0, z, a",
            "1, z, b",
            "2, z, c",
            "3, z, d"
    })
    void set(int index, String element, String expected) {
        assertEquals(expected, testList.set(index, element));
    }

    @DisplayName("Test set method with invalid index")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5, 6, 7, 8, 9, 10})
    void setInvalidIndex(int index) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testList.set(index, "z"));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test size method")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void size(int addSize) {
        for (int i = 0; i < addSize; i++) {
            testList.add("z");
        }
        assertEquals(4 + addSize, testList.size());
    }
}
