package salesTaxesProgram;

public class SalesTax extends TaxDecorator {

	private Product productToDecorate;
		
		private final double rate = 0.1;
		
		public SalesTax(Product product) {
			super(product);
			productToDecorate = product;
		}
	
		@Override
		public String getDescription() {
			return productToDecorate.getDescription();
			}
	
		@Override
		public double getPrice() {
			return productToDecorate.getPrice();	
		}
	
		@Override
		public boolean getExempt() {
			return productToDecorate.getExempt();
		}
	
		@Override
		double getRate() {
			return rate;
		}
}
