import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Max3Test {

    @Test
    @DisplayName("Test max3 with 3 positive numbers")
    void max3Positive() {
        assertEquals(5, Max3.max3(2, 3, 5));
    }

    @Test
    @DisplayName("Test max3 with 3 negative numbers")
    void max3Negative() {
        assertEquals(-2, Max3.max3(-2, -3, -5));
    }

    @Test
    @DisplayName("Test max3 with 3 mixed positive and negative numbers")
    void max3Mixed() {
        assertEquals(3, Max3.max3(-2, 3, -5));
    }

    @Test
    @DisplayName("Test max3 with 3 mixed ordered numbers")
    void max3Order() {
        assertEquals(7, Max3.max3(5, 7, 3));
    }

    @Test
    @DisplayName("Test max3 with 3 equal numbers")
    void max3Equal() {
        assertEquals(7, Max3.max3(7, 7, 7));
    }

    @Test
    @DisplayName("Test max3 with 2 larger equal numbers")
    void max3TwoLargerEqual() {
        assertEquals(7, Max3.max3(7, 7, 5));
    }

    @Test
    @DisplayName("Test max3 with 2 smaller equal numbers")
    void max3TwoSmallerEqual() {
        assertEquals(7, Max3.max3(5, 5, 7));
    }
}