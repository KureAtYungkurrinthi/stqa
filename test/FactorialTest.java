import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @DisplayName("Test factorial between 0 and 12")
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
    })
    void factorial(int n, int expected) {
        assertEquals(expected, Factorial.factorial(n));
    }

    @DisplayName("Test factorial exception for numbers in undefined range")
    @ParameterizedTest
    @CsvSource({"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10", "13", "14", "15", "16", "17", "18", "19", "20",})
    void factorialException(int n) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(n));
        assertEquals(n > 12 ? "Factorial(" + n + ") is too large - overflow occurs!" : "Factorial is undefined for negative integers", exception.getMessage());
    }

    @Test
    void main() {
        InputStream in = new ByteArrayInputStream("5\ny\n-2\nY\n25\ny\n8\nn\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Factorial.main(new String[]{});

        String expectedOutput = "Enter an integer: Factorial(5) = 120\n"
                + "Another factorial? (y/n): "
                + "Enter an integer: "
                + "java.lang.IllegalArgumentException: Factorial is undefined for negative integers\n"
                + "Another factorial? (y/n): "
                + "Enter an integer: "
                + "java.lang.IllegalArgumentException: Factorial(25) is too large - overflow occurs!\n"
                + "Another factorial? (y/n): "
                + "Enter an integer: "
                + "Factorial(8) = 40320\n"
                + "Another factorial? (y/n): ";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}