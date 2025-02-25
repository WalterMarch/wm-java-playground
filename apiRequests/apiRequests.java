import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class apiRequests {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String newsSections = getNewsSections(client);
            String newsSection = setANewsSectionString(newsSections);
            String news = getNews(client, newsSection);
            System.out.println(news);    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNewsSections(HttpClient client) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ok.surf/api/v1/news-section-names"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String setANewsSectionString(String responseBody) {
        String[] trimmedResponseBody = responseBody.substring(1, responseBody.length() - 2).split(",");

        Random random = new Random();
        int index = random.nextInt(trimmedResponseBody.length);

        String sectionName = trimmedResponseBody[index];
        String trimmedSectionName = sectionName.substring(1, sectionName.length() - 1);

        return trimmedSectionName;
    }

    public static String getNews(HttpClient client, String newsSection) {
        String data = "{\"sections\":[\"" + newsSection + "\"]}";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ok.surf/api/v1/news-section"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}