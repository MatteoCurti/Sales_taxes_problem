package salesTaxesProgram;

public class Purchase extends Product {

	private int quantity;
	
	public Purchase (int quantity, String description, double price) {
		super(description, price);
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
}
