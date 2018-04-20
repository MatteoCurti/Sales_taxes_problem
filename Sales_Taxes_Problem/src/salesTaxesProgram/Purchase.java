package salesTaxesProgram;

public class Purchase extends Product {

	private int quantity;
	
	public Purchase (int quantity, String description, double price) {
		super(description, price);
		if (quantity <= 0) {
			this.quantity = 1;
			return ;
		} 
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
}
