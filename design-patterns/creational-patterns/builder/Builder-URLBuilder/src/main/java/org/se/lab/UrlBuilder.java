package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UrlBuilder
{
    private String protocol = "https"; // Variant: default value
    private Integer port = 80;
    private String host;
    private String application;
    private List<String> parameters = new ArrayList<>();

    public UrlBuilder()
    {
    }

    // Variant: force protocol and host
    public UrlBuilder(String protocol, String host )
    {
        // Variant: Input validation
        if(protocol == null)
            throw new IllegalArgumentException("Invalid protocol");

        if(host == null)
            throw new IllegalArgumentException("Invalid host");

        this.protocol = protocol;
        this.host = host;
    }

    public UrlBuilder http()
    {
        this.protocol = "http";
        return this;
    }
    
    public UrlBuilder https()
    {
        this.protocol = "https";
        return this;
    }

    public UrlBuilder ftp()
    {
        this.protocol = "ftp";
        return this;
    }

    public UrlBuilder file()
    {
        this.protocol = "file";
        return this;
    }
    
    public UrlBuilder port(Integer port)
    {
        this.port = port;
        return this;
    }

    public UrlBuilder host(String host)
    {
        // Variant: Validation
        if(host == null)
            throw new IllegalArgumentException("Invalid host!");

        this.host = host;
        return this;
    }

    public UrlBuilder application(String application)
    {
        if(application == null)
            throw new IllegalArgumentException("Invalid application name!");

        this.application = application;
        return this;
    }

    public UrlBuilder parameter(String paramName, String paramValue)
    {
        if(paramName == null)
            throw new IllegalArgumentException("Invalid parameter name!");
        if(paramValue == null)
            throw new IllegalArgumentException("Invalid parameter value!");

        String value = paramName + "=" + paramValue.replace(" ", "+");
        parameters.add(value);
        return this;
    }

    public String build()
    {
        StringBuilder url = new StringBuilder();
        url.append(protocol).append("://").append(host);

        if (port != null)
        {
            url.append(":").append(port);
        }

        url.append('/').append(application);
        if(parameters.size() > 0)
            url.append(generateQuery(parameters));
        else
            url.append('/');
        return url.toString();
    }
    
    
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
