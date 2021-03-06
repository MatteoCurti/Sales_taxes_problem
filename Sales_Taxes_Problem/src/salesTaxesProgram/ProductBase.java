package salesTaxesProgram;

import java.util.ArrayList;

import exemptProduct.ExemptProduct;

public class ProductBase implements Product {

	private String description;
	private double price;
	private boolean exempt;
	private boolean imported;
	
	public  ProductBase(String description, double price) {
		if (price<0.0) {
			this.description = "Error price";
			return ;
		}
		this.description = description;
		this.price = price;
		this.exempt = isExempt(description);
		this.imported = isImported(description);
	}

	private boolean isImported(String description) {
		if(description.contains("imported")) 
			return true;
		else 
			return false;
	}

	private boolean isExempt(String description) {
		
		ArrayList<String> al = ExemptProduct.List();
		
		for (int i = 0 ; i < al.size(); i++)
			if(description.contains(al.get(i))) 
				return true;
		
		return false;
		
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getPrice() {
		return this.price;
	}
	
	public boolean getExempt() {
		return this.exempt;
	}

	@Override
	public double getPriceWithTax() {
		return this.getPrice();
	}

	@Override
	public boolean getImport() {
		return this.imported;
	}
	
}
