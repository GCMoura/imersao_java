import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        // acessar os dados e fazer conexão HTTP
        String url = "https://api.mocki.io/v2/549a5d8b";
        
        URI uri = URI.create(url);
        
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());   

        String body = response.body();
        
        // filtrar as informações (título, poster, classificação)
        JsonParser parser = new JsonParser();

        List<Map<String, String>> moviesList = parser.parse(body);

        // exibir os dados

        for(Map<String, String> movie: moviesList ){
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }

    }
}
