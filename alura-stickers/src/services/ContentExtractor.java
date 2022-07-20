package services;

import java.util.List;

import entities.Content;

public interface ContentExtractor{

  List<Content> extractContent(String body);

}