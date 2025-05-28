import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Build GET request to GitHub API (fetch user info for "octocat")
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .GET()
                    .build();

            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status code
            System.out.println("Status code: " + response.statusCode());

            // Print response body (JSON string)
            System.out.println("Response body:\n" + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
