import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) { // Listen on port 12345
            System.out.println("Server started. Waiting for clients...");
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected.");

            // Streams for reading from client and writing to client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // For server input

            String clientMsg, serverMsg;

            // Simple chat loop
            while (true) {
                // Read message from client
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

                // Read message from server user
                System.out.print("Server: ");
                serverMsg = keyboard.readLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Server closed the chat.");
                    break;
                }
            }

            clientSocket.close();
            System.out.println("Server shutting down.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
