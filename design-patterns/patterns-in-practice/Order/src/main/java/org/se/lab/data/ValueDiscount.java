package org.se.lab.data;

public class ValueDiscount 
    implements DiscountCommand
{
    private final OrderVisitor visitor;
    
    public ValueDiscount(OrderVisitor visitor)
    {
        if(visitor == null)
            throw new IllegalArgumentException("Invalid Visitor!");
        this.visitor = visitor; 
    }
    
	public long  discountPrice(Order order)
	{ 
	    long price = visitor.visit(order); 
	    long discount = 0;
	    
	    if(price > 50000) // -15%
	    {
	        discount =  price * 15/100;
	    }
	    else if(price > 10000)  // -10%
        {
            discount = price * 10/100;
        }

	    return price - discount;
	}
}
