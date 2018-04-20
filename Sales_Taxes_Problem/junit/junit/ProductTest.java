package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import salesTaxesProgram.Product;

class ProductTest {

	@Test
	void testBook() {
		Product p = new Product("book", 12.49);
		assertEquals("book 12.49", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testMusic() {
		Product p = new Product("music CD", 14.99);
		assertEquals("music CD 14.99", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testBar() {
		Product p = new Product("chocolate bar", 0.85);
		assertEquals("chocolate bar 0.85", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testNegativePrice() {
		Product p = new Product("book", -12.49);
		assertEquals("Error price 0.0", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testBookPurchace() {
		Purchase a = new Purchase(2, "book", 12.49);	
		assertEquals("2 book 12.49", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	/*
	@Test
	void testMusicPurchace() {
		Purchase a = new Purchase(1, "music CD", 14.99);
		assertEquals("1 music CD 14.99", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	/*
	@Test
	void testBarPurchace() {
		Purchase a = new Purchase(1, "chocolate bar", 0.85);
		assertEquals("1 chocolate bar 0.85", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());	
	}
	*/
}
