package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.Product;
import org.se.lab.ShoppingCart;

public class ShoppingCartTest
{
	/*
	 * Association: ----[1]-> card:ShoppingCard
	 */
	private ShoppingCart card;

	@Before
	public void setup()
	{
		card = new ShoppingCart();

		Product p1 = new Product(3, "Java Programming", 3590);
		Product p2 = new Product(7, "Exile on Main St", 1450);

		card.addProduct(p1);
		card.addProduct(p2);
	}

	@Test
	public void testShoppingCardSize()
	{
		assertEquals(2, card.getProducts().size());
	}

	@Test
	public void testShoppingProducts()
	{
		Product p1 = card.getProducts().get(0);
		assertEquals("Java Programming", p1.getTitle());

		Product p2 = card.getProducts().get(1);
		assertEquals("Exile on Main St", p2.getTitle());
	}


	@Test
	public void testCalculateTotalSum()
	{
		long sum = 3590 + 1450;
		long result = card.calculateTotalSum();

		assertEquals(sum, result);
	}

	@Test
	public void testCalculateTax()
	{
		long sum = 3590 + 1450;
		long tax = sum * 20 /100;
		long result = card.calculateTax();

		assertEquals(tax, result);
	}

	@Test
	public void testCalculateTax25()
	{
		final int TAXRATE = 25;
		card.setTaxrate(TAXRATE);

		long sum = 3590 + 1450;
		long tax = sum * TAXRATE /100;
		long result = card.calculateTax();

		assertEquals(tax, result);
	}

}