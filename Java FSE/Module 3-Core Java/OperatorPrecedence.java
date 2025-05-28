public class OperatorPrecedence {
    public static void main(String[] args) {
        // Example 1
        int result1 = 10 + 5 * 2;
        // Multiplication has higher precedence: 5 * 2 = 10, then 10 + 10 = 20

        // Example 2
        int result2 = (10 + 5) * 2;
        // Parentheses override precedence: 10 + 5 = 15, then 15 * 2 = 30

        // Example 3
        int result3 = 100 / 5 + 3 * 4 - 2;
        // Division and multiplication first: 100/5 = 20, 3*4 = 12
        // Then addition and subtraction: 20 + 12 = 32, 32 - 2 = 30

        System.out.println("Result 1 (10 + 5 * 2): " + result1);
        System.out.println("Result 2 ((10 + 5) * 2): " + result2);
        System.out.println("Result 3 (100 / 5 + 3 * 4 - 2): " + result3);
    }
}