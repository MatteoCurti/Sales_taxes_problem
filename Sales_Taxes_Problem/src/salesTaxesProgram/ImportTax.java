package salesTaxesProgram;

public class ImportTax extends TaxDecorator {

	private Product productToDecorate;
		
		private final double rate = 0.05;
		
		public ImportTax(Product product) {
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

		@Override
		public boolean getImport() {
			return productToDecorate.getImport();
		}
}
