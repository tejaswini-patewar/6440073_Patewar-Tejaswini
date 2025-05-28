import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEvenFilter {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 57, 60);

        // Use Stream API to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        // Display the result
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
