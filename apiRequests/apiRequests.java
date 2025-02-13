import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class apiRequests {
    public static void main(String[] args) {
        String newSection = getNewsSection();
        System.out.println(newSection);
    }

    public static String getNewsSection() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ok.surf/api/v1/news-section-names"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String[] trimmedResponseBody = responseBody.substring(1, responseBody.length() - 2).split(",");

            Random random = new Random();
            int index = random.nextInt(trimmedResponseBody.length);

            String sectionName = trimmedResponseBody[index];
            String trimmedSectionName = sectionName.substring(1, sectionName.length() - 1);

            return trimmedSectionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}