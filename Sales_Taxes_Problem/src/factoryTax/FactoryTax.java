package factoryTax;

import salesTaxesProgram.Product;
import salesTaxesProgram.SalesTax;

public class FactoryTax {
	
	public static Product create(Product product) {
		
		if (!product.getExempt()) 
			product = new SalesTax(product);
		
			return product;
	}
	
}
