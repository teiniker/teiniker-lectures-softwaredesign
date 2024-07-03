package org.se.lab;

public class ProductBuilder
{
    private long id;
    private String description;
    private long price;
    private OrderLineBuilder lineBuilder;

    public ProductBuilder(OrderLineBuilder lineBuilder)
    {
        this.lineBuilder = lineBuilder;
    }


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


    public OrderLineBuilder line()
    {
        return lineBuilder.line();
    }

    public Order build()
    {
        return lineBuilder.build();
    }
}
