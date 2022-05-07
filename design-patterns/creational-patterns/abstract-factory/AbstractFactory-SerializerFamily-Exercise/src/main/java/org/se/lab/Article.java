package org.se.lab;

public class Article
{
    public Article(int id, String description, long price)
    {
        this.id = id;
        this.description = description;
        this.price = price;
    }


    private int id;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }


    private String description;
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }


    private long price;
    public long getPrice()
    {
        return price;
    }
    public void setPrice(long price)
    {
        this.price = price;
    }
}
