package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import round.Round;
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
		assertEquals("1 music CD: 16.49", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());
	}
	
	@Test
	void testBarExpense() {
		Purchase a = Purchase.parse("1 chocolate bar at 0.85");
		assertEquals("1 chocolate bar: 0.85", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());	
	}
	
	@Test
	void testOutput1() {
		ArrayList<Purchase> al = new ArrayList<Purchase>();
		al.add(Purchase.parse("2 book at 12.49"));
		al.add(Purchase.parse("1 music CD at 14.99"));
		al.add(Purchase.parse("1 chocolate bar at 0.85"));
		
		Purchase p;
		double totalPrice = 0.0;
		double totalWithTax = 0.0;
		for(int i = 0 ; i < al.size() ; i++) {
			p = al.get(i); 
			totalPrice += p.getPrice() * p.getQuantity();
			totalWithTax += Double.parseDouble(p.getPricePurchase());
		}
		assertEquals("Sales Taxes: 1.50", "Sales Taxes: " + Round.format(totalWithTax - totalPrice));	
		assertEquals("Total: 42.32", "Total: " + Round.format(totalWithTax));	
	}
	
	@Test
	void testBoxChocolates() {
		Purchase a = Purchase.parse("1 imported box of chocolates at 10.00");
		assertEquals("1 imported box of chocolates: 10.50", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());
	}
	
	@Test
	void testPerfume() {
		Purchase a = Purchase.parse("1 imported bottle of perfume at 47.50");
		assertEquals("1 imported bottle of perfume: 54.65", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());
	}
	
	@Test
	void testOutput2() {
		ArrayList<Purchase> al = new ArrayList<Purchase>();
		al.add(Purchase.parse("1 imported box of chocolates at 10.00"));
		al.add(Purchase.parse("1 imported bottle of perfume at 47.50"));
		
		Purchase p;
		double totalPrice = 0.0;
		double totalWithTax = 0.0;
		for(int i = 0 ; i < al.size() ; i++) {
			p = al.get(i); 
			totalPrice += p.getPrice() * p.getQuantity();
			totalWithTax += Double.parseDouble(p.getPricePurchase());
		}
		assertEquals("Sales Taxes: 7.65", "Sales Taxes: " + Round.format(totalWithTax - totalPrice));	
		assertEquals("Total: 65.15", "Total: " + Round.format(totalWithTax));	
	}
	
	@Test
	void testPills() {
		Purchase a = Purchase.parse("1 packet of headache pills at 9.75");
		assertEquals("1 packet of headache pills: 9.75", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());		
	}
	
	@Test
	void testImportedEverywhere() {
		Purchase a = Purchase.parse("3 box of imported chocolates at 11.25");
		assertEquals("3 imported box of chocolates: 35.55", a.getQuantity() + " " + a.getDescription() + ": " + a.getPricePurchase());		
	}
	
	@Test
	void testOutput3() {
		ArrayList<Purchase> al = new ArrayList<Purchase>();
		al.add(Purchase.parse("1 imported bottle of perfume at 27.99"));
		al.add(Purchase.parse("1 bottle of perfume at 18.99"));
		al.add(Purchase.parse("1 packet of headache pills at 9.75"));
		al.add(Purchase.parse("3 box of imported chocolates at 11.25"));
				
		Purchase p;
		double totalPrice = 0.0;
		double totalWithTax = 0.0;
		for(int i = 0 ; i < al.size() ; i++) {
			p = al.get(i); 
			totalPrice += p.getPrice() * p.getQuantity();
			totalWithTax += Double.parseDouble(p.getPricePurchase());
		}
		assertEquals("Sales Taxes: 7.90", "Sales Taxes: " + Round.format(totalWithTax - totalPrice));	
		assertEquals("Total: 98.38", "Total: " + Round.format(totalWithTax));	
	}
	
}
