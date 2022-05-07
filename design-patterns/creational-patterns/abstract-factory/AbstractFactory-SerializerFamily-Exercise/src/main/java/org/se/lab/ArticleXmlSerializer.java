package org.se.lab;

import java.util.List;

class ArticleXmlSerializer // package private
    implements ArticleSerializer
{

    @Override
    public String serialize(Article article)
    {
        StringBuilder xml = new StringBuilder();
        xml.append("<article ")
            .append("id=\"").append(article.getId()).append("\" ")
            .append("price=\"").append(article.getPrice()).append("\">")
            .append(article.getDescription())
        .append("</article>");        
        return xml.toString();
    }

    @Override
    public String serialize(List<Article> list)
    {
        StringBuilder xml = new StringBuilder();
        xml.append("<articles>");
        for(Article article : list)
        {
            xml.append(serialize(article));
        }
        
        xml.append("</articles>");
        return xml.toString();
    }
}
