// Thread task using Runnable
class MessagePrinter implements Runnable {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        // Print message 5 times
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " [" + i + "]");
            try {
                Thread.sleep(500); // just to slow it down a bit so we can see the mixing
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        // Create Runnable objects
        Runnable task1 = new MessagePrinter("Hello from Thread 1");
        Runnable task2 = new MessagePrinter("Hello from Thread 2");

        // Wrap them in Thread objects
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
