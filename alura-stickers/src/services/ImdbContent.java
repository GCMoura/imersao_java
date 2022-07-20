package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Content;

public class ImdbContent implements ContentExtractor {
  public List<Content> extractContent(String body){

    // filtrar as informações (título, poster, classificação)
    JsonParser parser = new JsonParser();

    List<Map<String, String>> attributesList = parser.parse(body);

    List<Content> contents = new ArrayList<>();

    // popular a lista

    for(Map<String, String> attributes : attributesList ){
      String movieTitle = attributes.get("title");

      String urlImage = attributes.get("image");

      Content content = new Content(movieTitle, urlImage);

      contents.add(content);

    }

    return contents;

  }
}
