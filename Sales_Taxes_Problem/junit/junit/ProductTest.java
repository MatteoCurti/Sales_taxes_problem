package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testBook() {
		Product p = new Product("book", 12.49);
		assertEquals("book 12.49", p.getDescription() + " " + p.getPrice());
	}
	/*
	@Test
	void testMusic() {
		Product p = new Product("music CD", 14.99);
		assertEquals("music CD 14.99", p.getDescription() + " " + p.getPrice());
	}
	/*
	@Test
	void testBar() {
		Product p = new Product("chocolate bar", 0.85);
		assertEquals("chocolate bar 0.85", p.getDescription() + " " + p.getPrice());
	}
	*/
}
