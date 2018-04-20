package salesTaxesProgram;

public interface Product {
	
	String getDescription();
	double getPrice();
	boolean getExempt();
	
	double getPriceWithTax();
	
	}
