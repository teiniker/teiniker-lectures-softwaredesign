package org.se.lab;

import java.util.List;

public interface ArticleSerializer
{
    String serialize(Article article);
    String serialize(List<Article> list);
}
