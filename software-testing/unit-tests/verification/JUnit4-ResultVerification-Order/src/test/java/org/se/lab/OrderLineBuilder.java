package org.se.lab;

public class OrderLineBuilder
{
    private long id;
    private int quantity;
    private ProductBuilder productBuilder;
    private OrderBuilder orderBuilder;

    public OrderLineBuilder(OrderBuilder orderBuilder)
    {
        this.orderBuilder = orderBuilder;
    }

    // Builder operations

    public OrderLineBuilder id(long id)
    {
        this.id = id;
        return this;
    }

    public OrderLineBuilder quantity(int quantity)
    {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder product()
    {
        productBuilder = new ProductBuilder(this);
        return productBuilder;
    }

    public OrderLine toOrderLine()
    {

        OrderLine line = new OrderLine(id, quantity, productBuilder.toProduct());
        return line;
    }

    public OrderLineBuilder line()
    {
        return orderBuilder.line();
    }

    public Order build()
    {
        return orderBuilder.build();
    }
}
