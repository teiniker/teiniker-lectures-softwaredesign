package org.se.lab;

import java.util.List;

public class UrlBuilder
{
    
    /*
     * Helper methods
     */

    private String generateQuery(List<String> parameters)
    {
        StringBuilder query = new StringBuilder();
        query.append('?');
        for(String p: parameters)
        {
            query.append(p).append('&');
        }
        return query.substring(0, query.length()-1);
    }
}
