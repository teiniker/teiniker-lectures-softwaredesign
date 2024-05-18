package org.se.lab.data;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DiscountCommandTest 
{
	private Order order;
	
	@Before
	public void setup()
	{
	    IntegerSequence.setInitValue(1);
	    order = new Order(IntegerSequence.nextValue(), new GregorianCalendar(2016,06,18).getTime(), ShippingType.REGULAR);
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 10, new Product(IntegerSequence.nextValue(), "Head First Design Patterns", 4900)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 5, new Product(IntegerSequence.nextValue(), "Patterns kompakt", 1499)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 7, new Product(IntegerSequence.nextValue(), "Design Patterns.", 4295)));
	}
	
	
	@Test
	public void testShippingDiscountRegular()
	{
	    DiscountCommand cmd = new ShippingDiscount(new TotalPriceVisitor());
	    
	    long discountPrice = cmd.discountPrice(order);
	    long totalPrice = 10*4900 + 5*1499 + 7*4295;
	    long expectedDiscountPrice = totalPrice - totalPrice * 5/100;
	    Assert.assertEquals(expectedDiscountPrice, discountPrice);	    
	}

    @Test
    public void testShippingDiscountExpress()
    {
        order.setShippingType(ShippingType.EXPRESS);
        
        DiscountCommand cmd = new ShippingDiscount(new TotalPriceVisitor());
        
        long discountPrice = cmd.discountPrice(order);
        long totalPrice = 10*4900 + 5*1499 + 7*4295;
        Assert.assertEquals(totalPrice, discountPrice);      
    }

    @Test
    public void testValueDiscountBigOrder()
    {
        DiscountCommand cmd = new ValueDiscount(new TotalPriceVisitor());        
        long discountPrice = cmd.discountPrice(order);
        long totalPrice = 10*4900 + 5*1499 + 7*4295; // = 86560 > 50000
        long expectedDiscountPrice = totalPrice - totalPrice * 15/100;
        Assert.assertEquals(expectedDiscountPrice, discountPrice);      
    }

    @Test
    public void testValueDiscountSmallOrder()
    {
        order.setShippingType(ShippingType.EXPRESS);
        
        for(OrderLine line : order.getOrderlines())
        {
            line.setQuantity(1);
        }
        
        DiscountCommand cmd = new ValueDiscount(new TotalPriceVisitor());
        
        long discountPrice = cmd.discountPrice(order);
        long totalPrice = 1*4900 + 1*1499 + 1*4295; // = 10694;
        long expectedDiscountPrice = totalPrice - totalPrice * 10/100;
        System.out.println(totalPrice);
        Assert.assertEquals(expectedDiscountPrice, discountPrice);    
    }

    @Test
    public void testValueDiscountTinyOrder()
    {
        order.setShippingType(ShippingType.EXPRESS);        
        order.getOrderlines().get(0).setQuantity(1);
        order.getOrderlines().get(1).setQuantity(0);
        order.getOrderlines().get(2).setQuantity(0);
        
        DiscountCommand cmd = new ValueDiscount(new TotalPriceVisitor());
        
        long discountPrice = cmd.discountPrice(order);
        long totalPrice = 1*4900 + 0*1499 + 0*4295; // = 4900;
        long expectedDiscountPrice = totalPrice;
        System.out.println(totalPrice);
        Assert.assertEquals(expectedDiscountPrice, discountPrice);    
    }
}
