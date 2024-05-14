package org.se.lab.version1;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.CustomAssert;
import org.se.lab.Order;
import org.se.lab.OrderLine;
import org.se.lab.Product;

public class OrderBuilderTest
{
    private Order order;

    @Before
    public void setup()
    {
        // SUT
        order = new Order(1, "Special order");
        order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
        order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));
    }

    @Test
    public void testOrderBuilder()
    {
        Order expected = new OrderBuilder().id(1).name("Special order")
                .lines(
                    new OrderLineBuilder().id(2).quantity(1).product(
                        new ProductBuilder().id(3).description("Pizza Frutti di Mare").price(880).toProduct()).toOrderLine(),
                    new OrderLineBuilder().id(4).quantity(2).product(
                        new ProductBuilder().id(5).description("Pizza Quattro Formaggi").price(820).toProduct()).toOrderLine()
                ).toOrder();

        CustomAssert.assertEquals(expected, order);
    }
}

