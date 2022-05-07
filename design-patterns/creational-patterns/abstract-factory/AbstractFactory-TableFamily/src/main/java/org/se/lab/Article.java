package org.se.lab;

public class Article
{
    private int id;
    private String description;
    private double price;
    
    
    public Article(int id, String description, double price)
    {
        this.id = id;
        this.description = description;
        this.price = price;
    }


    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }


    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }


    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
}
