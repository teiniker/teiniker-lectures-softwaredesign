package org.se.lab.data;

public class ShippingDiscount 
    implements DiscountCommand
{
    private final OrderVisitor visitor;
    
    public ShippingDiscount(OrderVisitor visitor)
    {
        if(visitor == null)
            throw new IllegalArgumentException("Invalid Visitor!");
        this.visitor = visitor; 
    }
    
    public long discountPrice(Order order)
	{
        long price = visitor.visit(order);
        long discount = 0;
        
        if(order.getShippingType() == ShippingType.REGULAR) // -5%
        {
            discount = price * 5/100;
        }
        
        return price - discount;
	}
}
