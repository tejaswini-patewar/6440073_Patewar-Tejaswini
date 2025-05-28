import java.util.concurrent.*;
import java.util.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Fixed 5 threads

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            tasks.add(() -> {
                return "Task " + taskId + " executed by " + Thread.currentThread().getName();
            });
        }

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}