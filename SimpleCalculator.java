
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        // Create Scanner to get input from the user
        Scanner sc = new Scanner(System.in);

        try {
            // Get the first number
            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            // Get the operator
            System.out.print("Enter operator (+, -, *, /): ");
            String operator = sc.next();

            // Get the second number
            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            double result;

            // Perform the selected arithmetic operation
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    // Prevent division by zero
                    if (num2 == 0) {
                        throw new ArithmeticException(
                            "Division by zero is not allowed."
                        );
                    }
                    result = num1 / num2;
                    break;

                default:
                    System.out.println("Invalid operator!");
                    return;
            }

            // Display the result
            System.out.println("Result: " + result);

        } catch (java.util.InputMismatchException e) {
            // Handle invalid number input
            System.out.println("Error: Please enter valid numbers.");

        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Close the Scanner
            sc.close();
        }
    }
}
