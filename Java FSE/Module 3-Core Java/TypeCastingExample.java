public class TypeCastingExample {
    public static void main(String[] args) {
        double doubleVal = 45.67;
        int intVal = (int) doubleVal; // Casting double to int

        System.out.println("Double value: " + doubleVal);
        System.out.println("After casting to int: " + intVal);

        int anotherInt = 100;
        double newDouble = (double) anotherInt; // Casting int to double

        System.out.println("Int value: " + anotherInt);
        System.out.println("After casting to double: " + newDouble);
    }
}