package salesTaxesProgram;

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
		
		if(description.contains("book")) return true;
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
