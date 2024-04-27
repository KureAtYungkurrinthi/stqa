public class Factorial {
    /**
     * Returns the factorial of the argument given
     *
     * @param n the number for which to calculate the factorial
     * @return the factorial
     */
    public static int factorial(int n) {

        int fact = 1;
        for (int i = n; i > 0; i--)
            fact *= i;
        return fact;
    }
}
