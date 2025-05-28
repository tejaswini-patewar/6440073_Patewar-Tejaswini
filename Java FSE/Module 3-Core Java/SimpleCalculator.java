import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for two numbers
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Prompt user for the operation
        System.out.println("Choose an operation: +, -, *, /");
        System.out.print("Enter operation: ");
        char op = scanner.next().charAt(0);

        double result;

        // Perform calculation based on operation
        switch (op) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Error! Division by zero.");
                    scanner.close();
                    return;
                }
                result = num1 / num2;
                break;

            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        // Display result
        System.out.println("Result: " + result);
        scanner.close();
    }
}