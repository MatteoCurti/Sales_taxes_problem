package salesTaxesProgram;

public interface Product {
	
	String getDescription();
	double getPrice();
	boolean getExempt();
	boolean getImport();
	
	double getPriceWithTax();
	
	}
