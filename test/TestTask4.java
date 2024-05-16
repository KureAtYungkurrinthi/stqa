import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTask4 {
    StringList testList;

    @BeforeEach
    void setUp() {
        testList = new StringList();
        String[] elements = {"a", "b", "c", "d"};
        for (String element : elements) {
            testList.add(element);
        }
    }

    @DisplayName("Test lastIndexOf method")
    @ParameterizedTest
    @CsvSource({"a, 0", "b, 1", "c, 2", "d, 3", "e, -1"})
    void lastIndexOf(String element, int expected) {
        assertEquals(expected, testList.lastIndexOf(element));
    }

    @DisplayName("Test subList method")
    @ParameterizedTest
    @CsvSource({"0, 2, a, b", "1, 3, b, c", "2, 4, c, d"})
    void subList(int fromIndex, int toIndex, String expected1, String expected2) {
        StringList subList = testList.subList(fromIndex, toIndex);
        assertEquals(2, subList.size());
        assertEquals(expected1, subList.get(0));
        assertEquals(expected2, subList.get(1));
    }

    @DisplayName("Test subList IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"-1, 2", "1, 5", "5, 8", "3, 1"})
    void subListInvalidIndexes(int fromIndex, int toIndex) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.subList(fromIndex, toIndex));
        if (fromIndex > toIndex) {
            assertEquals("Indices out of order", exception.getMessage());
        } else {
            assertEquals("Invalid index", exception.getMessage());
        }
    }

    @DisplayName("Test removeRange method")
    @ParameterizedTest
    @CsvSource({"0, 2, c, d", "1, 3, a, d", "2, 4, a, b"})
    void removeRange(int fromIndex, int toIndex, String expected1, String expected2) {
        testList.removeRange(fromIndex, toIndex);
        assertEquals(2, testList.size());
        assertEquals(expected1, testList.get(0));
        assertEquals(expected2, testList.get(1));

    }

    @DisplayName("Test removeRange IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"-1, 2", "1, 5", "5, 8", "3, 1"})
    void removeRangeInvalidIndexes(int fromIndex, int toIndex) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testList.removeRange(fromIndex, toIndex));
        if (fromIndex > toIndex) {
            assertEquals("Indices out of order", exception.getMessage());
        } else {
            assertEquals("Invalid index", exception.getMessage());
        }
    }

    @DisplayName("Test equals method")
    @ParameterizedTest
    @CsvSource({"1, false", "2, false", "3, false", "4, true"})
    void testEquals(int size, boolean expected) {
        StringList testList2 = new StringList(2);
        StringList testList3 = new StringList(3);
        String[] elements1 = {"a", "b", "c", "d", "e"};
        String[] elements2 = {"e", "d", "c", "b", "a"};
        for (int i = 0; i < size; i++) {
            testList2.add(elements1[i]);
            testList3.add(elements2[i]);
        }
        assertEquals(expected, testList.equals(testList2));
        assertFalse(testList.equals(testList3));
    }

    @DisplayName("Test toArray method")
    @Test
    void toArray() {
        String[] expected = {"a", "b", "c", "d"};
        assertArrayEquals(expected, testList.toArray());
    }
}