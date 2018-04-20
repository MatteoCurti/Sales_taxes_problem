package salesTaxesProgram;

public abstract class TaxDecorator implements Product {
	
	protected Product product;
	protected double rate;
	
	abstract double getRate();

	public TaxDecorator(Product product){
		this.product = product;
	}

	public double getPriceWithTax(){
		double tax = Math.round((this.product.getPrice() * this.getRate()) * 100.0)/100.0;
		return Math.round((this.product.getPriceWithTax()*100.0))/100.0 + tax;
	}
}
