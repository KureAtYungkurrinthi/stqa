import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @DisplayName("Test factorial between 0 and 16")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800",
            "11, 39916800",
            "12, 479001600",
            "13, 1932053504",
            "14, 1278945280",
            "15, 2004310016",
            "16, 2004189184",
    })
    void factorial(int n, int expected) {
        assertEquals(expected, Factorial.factorial(n));
    }

    @DisplayName("Test factorial for negative numbers")
    @ParameterizedTest
    @CsvSource({
            "-1",
            "-2",
            "-3",
            "-4",
            "-5",
            "-6",
            "-7",
            "-8",
            "-9",
            "-10",
    })
    void factorialNegative(int n) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        assertEquals("Factorial is undefined for negative integers", exception.getMessage());
    }

    @DisplayName("Test factorial for numbers greater than 16")
    @ParameterizedTest
    @CsvSource({
            "17",
            "18",
            "19",
            "20",
    })
    void factorialOverflow(int n) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        assertEquals("Factorial(" + n + ") is too large - overflow occurs!", exception.getMessage());    }

    @Test
    void main() {

    }
}