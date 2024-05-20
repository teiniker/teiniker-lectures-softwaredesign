package org.se.lab.version1;

import org.se.lab.Order;
import org.se.lab.OrderLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderBuilder
{
    private long id;
    private String name;
    private List<OrderLine> lines = new ArrayList<>();


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

    public OrderBuilder lines(OrderLine... lines)
    {
        this.lines = Arrays.asList(lines);
        return this;
    }

    public Order toOrder()
    {
        Order order = new Order(id, name);
        order.getOrderLines().addAll(lines);
        return order;
    }
}
