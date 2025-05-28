import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Dynamically load the class by name
        Class<?> cls = Class.forName("SecretAgent");

        // Print all declared method names and their parameters
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.print("Method: " + m.getName() + " | Params: ");
            Class<?>[] params = m.getParameterTypes();
            for (Class<?> p : params) {
                System.out.print(p.getSimpleName() + " ");
            }
            System.out.println();
        }

        // Create an instance of SecretAgent
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Get the revealSecret method by name and parameter type
        Method reveal = cls.getDeclaredMethod("revealSecret", String.class);

        // Invoke revealSecret on the instance dynamically
        reveal.invoke(obj, "007");

        // Optionally, access the private method (topSecret)
        Method secret = cls.getDeclaredMethod("topSecret");
        secret.setAccessible(true);  // bypass private access
        secret.invoke(obj);
    }
}
