package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import salesTaxesProgram.Product;
import salesTaxesProgram.ProductBase;
import salesTaxesProgram.Purchase;

class ProductTest {

	@Test
	void testBook() {
		Product p = new ProductBase("book", 12.49);
		assertEquals("book 12.49", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testMusic() {
		Product p = new ProductBase("music CD", 14.99);
		assertEquals("music CD 14.99", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testBar() {
		Product p = new ProductBase("chocolate bar", 0.85);
		assertEquals("chocolate bar 0.85", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testNegativePrice() {
		Product p = new ProductBase("book", -12.49);
		assertEquals("Error price 0.0", p.getDescription() + " " + p.getPrice());
	}
	
	@Test
	void testBookPurchace() {
		Purchase a = new Purchase(2, "book", 12.49);	
		assertEquals("2 book 12.49", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	
	@Test
	void testMusicPurchace() {
		Purchase a = new Purchase(1, "music CD", 14.99);
		assertEquals("1 music CD 14.99", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	
	@Test
	void testBarPurchace() {
		Purchase a = new Purchase(1, "chocolate bar", 0.85);
		assertEquals("1 chocolate bar 0.85", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());	
	}
	
	@Test
	void testNegativePurchace() {
		Purchase a = new Purchase(-2, "book", 12.49);	
		assertEquals("1 book 12.49", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	
	@Test
	void testBookParse() {
		Purchase a = Purchase.parse("2 book at 12.49");	
		assertEquals("2 book 12.49", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	
	@Test
	void testMusicParse() {
		Purchase a = Purchase.parse("1 music CD at 14.99");
		assertEquals("1 music CD 14.99", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());
	}
	
	@Test
	void testBarParse() {
		Purchase a = Purchase.parse("1 chocolate bar at 0.85");
		assertEquals("1 chocolate bar 0.85", a.getQuantity() + " " + a.getDescription() + " " + a.getPrice());	
	}
	
	@Test
	void testBookExempt() {
		Purchase a = Purchase.parse("2 book at 12.49");	
		assertEquals(true, a.getExempt());
	}
	
	@Test
	void testMusicExempt() {
		Purchase a = Purchase.parse("1 music CD at 14.99");
		assertEquals(false, a.getExempt());
	}
	
	@Test
	void testBarExempt() {
		Purchase a = Purchase.parse("1 chocolate bar at 0.85");
		assertEquals(true, a.getExempt());
	}
	
	@Test
	void testBookExpense() {
		Purchase a = Purchase.parse("2 book at 12.49");	
		assertEquals("2 book: 24.98", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());
	}
	
	@Test
	void testMusicExpense() {
		Purchase a = Purchase.parse("1 music CD at 14.99");		
		//a.setProduct(FactoryTax.create(a.getProduct()));
		assertEquals("1 music CD: 16.49", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());
	}
	
	@Test
	void testBarExpense() {
		Purchase a = Purchase.parse("1 chocolate bar at 0.85");
		assertEquals("1 chocolate bar: 0.85", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());	
	}
	
}
