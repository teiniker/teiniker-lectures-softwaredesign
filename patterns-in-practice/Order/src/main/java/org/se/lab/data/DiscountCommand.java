package org.se.lab.data;

@FunctionalInterface
public interface DiscountCommand 
{
	long discountPrice(Order order);
}
