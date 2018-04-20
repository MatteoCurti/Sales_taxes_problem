package salesTaxesProgram;

import round.Round;

public abstract class TaxDecorator implements Product {
	
	protected Product product;
	protected double rate;
	
	abstract double getRate();

	public TaxDecorator(Product product){
		this.product = product;
	}

	public double getPriceWithTax(){
		double tax = Round.simple(this.product.getPrice() * this.getRate());
		tax = Round.to05(tax);
		return Round.simple(this.product.getPriceWithTax()) + tax;
	}
	
}
