package factoryTax;

import salesTaxesProgram.ImportTax;
import salesTaxesProgram.Product;
import salesTaxesProgram.SalesTax;

public class FactoryTax {
	
	public static Product create(Product product) {
		if (product.getImport()) 
			product = new ImportTax (product);
		
		if (!product.getExempt()) 
			product = new SalesTax(product);
		
			return product;
	}
	
}
