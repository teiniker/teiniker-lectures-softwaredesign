package org.se.lab.version2;

import org.se.lab.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder
{
    private long id;
    private String name;
    private List<OrderLineBuilder> lineBuilders = new ArrayList<>();


    // Builder operations

    public OrderBuilder id(long id)
    {
        this.id = id;
        return this;
    }

    public OrderBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public OrderLineBuilder line()
    {
        OrderLineBuilder lineBuilder = new OrderLineBuilder(this);
        lineBuilders.add(lineBuilder);
        return lineBuilder;
    }

    public Order build()
    {
        Order order = new Order(id, name);
        for(OrderLineBuilder line: lineBuilders)
        {
            order.addOrderLine(line.toOrderLine());
        }
        return order;
    }
}
