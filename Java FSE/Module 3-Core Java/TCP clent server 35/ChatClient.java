import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) { // Connect to server on localhost port 12345
            System.out.println("Connected to server.");

            // Streams for reading from server and writing to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // For client input

            String serverMsg, clientMsg;

            while (true) {
                // Read message from server
                serverMsg = in.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMsg);

                // Read message from client user
                System.out.print("Client: ");
                clientMsg = keyboard.readLine();
                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client closed the chat.");
                    break;
                }
            }

            socket.close();
            System.out.println("Client shutting down.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
