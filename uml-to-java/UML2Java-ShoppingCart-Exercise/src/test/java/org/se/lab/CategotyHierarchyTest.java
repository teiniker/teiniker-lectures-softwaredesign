package org.se.lab;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategotyHierarchyTest
{
	private Category book;

	/*
	 * "Books"
	 *    +-- "English Books"
	 *    |      +-- "Programming Books"
	 *    |             +-- "Programming C"
	 *    |             +-- "Java Programming"
	 *    +-- "German Books"
	 */  
	
	@Before
	public void setUp()
	{
		IntegerSequence.setInitValue(1);
		
		book = new Category("Books");		
		Category english = new Category("English Books");
		Category german = new Category("German Books");
		Category programming = new Category("Programming Books");
		
		book.addChild(english);
		english.setParent(book);
		
		book.addChild(german);
		german.setParent(book);
		
		english.addChild(programming);
		programming.setParent(english);

			
		Product p1 = new Product("Programming C", 1790);
		Product p2 = new Product("Java Programming", 3450);

		programming.addProduct(p1);
		p1.setCategory(programming);

		programming.addProduct(p2);
		p2.setCategory(programming);
	}

	@Test
	public void testCategoryBooks()
	{
		assertEquals(2, book.getChildren().size());
		
		Category englishBooks = book.getChildren().get(0); 
		assertEquals("English Books", englishBooks.getName());
		assertEquals("Books", englishBooks.getParent().getName());
		
		Category germanBooks =book.getChildren().get(1);
		assertEquals("German Books", germanBooks.getName());
		assertEquals("Books", germanBooks.getParent().getName());		
	}

	
	@Test
	public void testCategoryEnglishBooks()
	{
		Category englishBooks = book.getChildren().get(0); 
		assertEquals(1, englishBooks.getChildren().size());
		
		Category programmingBooks = englishBooks.getChildren().get(0);
		assertEquals("Programming Books", programmingBooks.getName());	
		assertEquals("English Books", programmingBooks.getParent().getName());
	}

	
	@Test
	public void testCategoryProgrammingBooks()
	{
		Category programmingBooks = book.getChildren().get(0).getChildren().get(0);
		assertEquals(2, programmingBooks.getProducts().size());
		
		Product p1 = programmingBooks.getProducts().get(0);
		assertEquals("Programming C", p1.getTitle());
		assertEquals("Programming Books", p1.getCategory().getName());
		
		Product p2 = programmingBooks.getProducts().get(1);
		assertEquals("Java Programming", p2.getTitle());
		assertEquals("Programming Books", p2.getCategory().getName());
	}
	
	
	@Test
	public void testToXml()
	{
		final String EXPECTED = 
			"<category id=\"1\" name=\"Books\">\n" +
				"<category id=\"2\" name=\"English Books\">\n" +
					"<category id=\"4\" name=\"Programming Books\">\n" +
						"<product id=\"5\" title=\"Programming C\" price=\"17.9\"/>\n" + 
						"<product id=\"6\" title=\"Java Programming\" price=\"34.5\"/>\n" +
					"</category>\n" +
				"</category>\n" +
				"<category id=\"3\" name=\"German Books\">\n" +
				"</category>\n" +
			"</category>";
		assertEquals(EXPECTED, book.toXml());
		System.out.println(book.toXml());
	}
}
