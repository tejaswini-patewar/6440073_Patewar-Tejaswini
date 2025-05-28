import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Define the record
record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        // Create instances
        Person p1 = new Person("Aarav", 21);
        Person p2 = new Person("Meera", 17);
        Person p3 = new Person("Kiran", 25);
        Person p4 = new Person("Zoya", 16);

        // Print them
        System.out.println("All Persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        // Put them in a list
        List<Person> people = Arrays.asList(p1, p2, p3, p4);

        // Filter people age >= 18 using Stream API
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
