package salesTaxesProgram;

public class TaxCalculator {

	public static final double SALES_TAXES = 0.1;
	
	public static double getPriceWithTax(Product p) {
		return p.getPrice() + getTaxes(p);
	}
	
	public static double getTaxes(Product p) {
		
		double taxes = 0.0;
		
		if (!p.getExempt()) 
			taxes = Math.round(p.getPrice() * SALES_TAXES * 100.0) / 100.0;
		
		return taxes;
	}
	
}
