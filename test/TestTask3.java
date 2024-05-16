import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTask3 {
    StringList testList;

    @DisplayName("Test int constructor and void add")
    @BeforeEach
    @Test
    void add() {
        testList = new StringList(5);
        int[] testIndexArray = {0, 1, 2, 3, 4};
        String[] testStringArray = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < testIndexArray.length; i++) {
            testList.add(testIndexArray[i], testStringArray[i]);
            assertEquals(testStringArray[i], testList.get(i));
        }
    }

    @DisplayName("Test add IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(ints = {10, -1})
    void addIllegalArgumentException(int index) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.add(index, "z"));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test remove by index")
    @ParameterizedTest
    @CsvSource({
            "0, a",
            "1, b",
            "2, c",
            "3, d",
            "4, e"
    })
    void removeIndex(int index, String expected) {
        assertEquals(expected, testList.remove(index));
    }

    @DisplayName("Test remove IllegalArgumentException by index")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void removeIllegalArgumentException(int index) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.remove(index));
        assertEquals("Invalid index: " + index, exception.getMessage());
    }

    @DisplayName("Test remove by element")
    @ParameterizedTest
    @CsvSource({
            "a, true",
            "b, true",
            "c, true",
            "d, true",
            "e, true",
            "f, false"
    })
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
