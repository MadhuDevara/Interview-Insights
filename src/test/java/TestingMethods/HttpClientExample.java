package TestingMethods;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientExample {
    public static void main(String[] args) {
        // Create the HTTP client
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create the GET request
            HttpGet request = new HttpGet("https://www.google.com/");

            // Execute the request
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Print the response code
                System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

                // Handle response body
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response Body: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
