package salesTaxesProgram;

import java.util.ArrayList;

import exemptProduct.ExemptProduct;

public class Product {
	
	private String description;
	private double price;
	private boolean exempt;
	
	
	public  Product(String description, double price) {
		if (price<0.0) {
			this.description = "Error price";
			return ;
		}
		this.description = description;
		this.price = price;
		this.exempt = isExempt(description);
	}

	private boolean isExempt(String description) {
		
		ArrayList<String> al = ExemptProduct.List();
		
		for (int i = 0 ; i < al.size(); i++)
			if(description.contains(al.get(i))) 
				return true;
		
		return false;
		
	}
	
	public String getDescription() {
		return this.description;
	}

	public double getPrice() {
		return this.price;
	}
	
	public boolean getExempt() {
		return this.exempt;
	}
}
