import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BmiCalculatorTest {

    @Test
    @DisplayName("Test constructor & accessor")
    void constructor() {
        BmiCalculator bmiCalculator = new BmiCalculator(100, 180);
        assertEquals(100, bmiCalculator.weight());
        assertEquals(180, bmiCalculator.height());
    }

    @ParameterizedTest
    @CsvSource({
            "50, 180, 'Your BMI is 15.4, which means you are in the Underweight range.'",
            "70, 180, 'Your BMI is 21.6, which means you are in the Normal range.'",
            "90, 180, 'Your BMI is 27.8, which means you are in the Overweight range.'",
            "110, 180, 'Your BMI is 34.0, which means you are in the Obese range.'",
    })
    @DisplayName("Test calculateBMI")
    void calculateBMI(int weight, int height, String BMI) {
        BmiCalculator bmiCalculator = new BmiCalculator(weight, height);
        assertEquals(BMI, bmiCalculator.calculateBMI());
    }
}