package org.se.lab;

import java.util.List;

class ArticleJsonSerializer // package private
    implements ArticleSerializer
{

    @Override
    public String serialize(Article article)
    {
        StringBuilder xml = new StringBuilder();
        xml.append("{")
            .append("\"id\":\"").append(article.getId()).append("\",")
            .append("\"price\":\"").append(article.getPrice()).append("\",")
            .append("\"description\":\"").append(article.getDescription()).append("\"")
        .append("}");        
        return xml.toString();
    }
    
    @Override
    public String serialize(List<Article> list)
    {
        StringBuilder xml = new StringBuilder();
        xml.append("[");
        for(int i=0; i < list.size(); i++)
        {            
            xml.append(serialize(list.get(i)));
            if(i != list.size()-1)
            {
                xml.append(',');
            }
        }
        xml.append("]");
        return xml.toString();
    }

}
