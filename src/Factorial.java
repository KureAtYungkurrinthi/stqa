import java.util.Scanner;

public class Factorial {
    /**
     * Returns the factorial of the argument given
     *
     * @param n the number for which to calculate the factorial
     * @return the factorial
     */
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative integers");
        } else if (n > 16) {
            throw new IllegalArgumentException("Factorial(" + n + ") is too large - overflow occurs!");
        } else {
            int fact = 1;
            for (int i = n; i > 0; i--)
                fact *= i;
            return fact;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ifContinue = true;
        while (ifContinue) {
            System.out.print("Enter an integer: ");
            int n = scanner.nextInt();
            try {
                System.out.println("Factorial(" + n + ") = " + factorial(n));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }

            System.out.print("nother factorial? (y/n): ");
            char c = scanner.next().charAt(0);
            if (c == 'n' || c == 'N') {
                ifContinue = false;
            }
        }
    }
}
