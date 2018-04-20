package salesTaxesProgram;

public class Product {
	
	private String description;
	private double price;
	
	public  Product(String description, double price) {
		if (price<0.0) {
			this.description = "Error price";
			return ;
		}
		this.description = description;
		this.price = price;
	}
	
	public String getDescription() {
		return this.description;
	}

	public double getPrice() {
		return this.price;
	}
}
