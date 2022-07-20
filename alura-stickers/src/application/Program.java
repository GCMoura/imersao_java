package application;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import entities.Content;
import entities.StickerFactory;
import services.ClientHttp;
import services.ContentExtractor;
import services.ImdbContent;
import services.JsonParser;
import services.NasaContent;


public class Program {

    public static void main(String[] args) throws Exception {

        // acessar os dados e fazer conexão HTTP
        //IMDB
        //String url = "https://api.mocki.io/v2/549a5d8b";
        // ContentExtractor extractor = new ImdbContent();

        //NASA
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ContentExtractor extractor = new NasaContent();
         
        ClientHttp clientHttp = new ClientHttp();
        String json = clientHttp.searchData(url);
        
        
        // exibir os dados

        List<Content> contentList = extractor.extractContent(json);

        StickerFactory factory = new StickerFactory();

        for(int i = 0; i < contentList.size(); i++){

            Content content = contentList.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();

            String fileName = content.getTitle() + ".png";

            factory.create(inputStream, fileName);

        }

    }
}
