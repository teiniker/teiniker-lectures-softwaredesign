package org.se.lab.version1;

import org.se.lab.Product;

public class ProductBuilder
{
    private long id;
    private String description;
    private long price;

    // Builder operations

    public ProductBuilder id(long id)
    {
        this.id = id;
        return this;
    }

    public ProductBuilder description(String description)
    {
        this.description = description;
        return this;
    }

    public ProductBuilder price(long price)
    {
        this.price = price;
        return this;
    }

    public Product toProduct()
    {
        return new Product(id, description, price);
    }

}
