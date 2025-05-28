public class PatternMatchingSwitch {

    public static void identifyObject(Object obj) {
        // switch expression with pattern matching introduced in Java 21
        String result = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String with value: \"" + s + "\"";
            case Double d -> "It's a Double with value: " + d;
            case null -> "It's null, bro!";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        identifyObject(42);
        identifyObject("Tejuu");
        identifyObject(3.14);
        identifyObject(true);
        identifyObject(null);
    }
}
