package org.se.lab.version1;

import org.se.lab.OrderLine;
import org.se.lab.Product;

public class OrderLineBuilder
{
    private long id;
    private int quantity;
    private Product product;

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

    public OrderLineBuilder product(Product product)
    {
        this.product = product;
        return this;
    }

    public OrderLine toOrderLine()
    {

        OrderLine line = new OrderLine(id, quantity, product);
        return line;
    }
}
