import java.util.Scanner;

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            // Check age and throw custom exception if under 18
            if (age < 18) {
                throw new InvalidAgeException("You must be at least 18 years old.");
            }
            System.out.println("Access granted. You're old enough!");

        } catch (InvalidAgeException e) {
            // Handle custom exception
            System.out.println("Access denied: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
