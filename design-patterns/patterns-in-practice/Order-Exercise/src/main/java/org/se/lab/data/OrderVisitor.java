package org.se.lab.data;

public interface OrderVisitor
{
    long visit(Product product);
    long visit(OrderLine orderline);
    long visit(Order order);
}
