package salesTaxesProgram;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
	
	public double getPricePurchase() {
		double d = this.quantity * this.getPrice();
		return d;
	}
	
	public static Purchase parse(String inputLine) {
		
		ArrayList<String> in = new ArrayList<String>();
	    StringTokenizer st = new StringTokenizer(inputLine, " ");
		    
	    while (st.hasMoreTokens())	    	
	        in.add(st.nextToken());

	    int quantity=Integer.parseInt(in.get(0));
	    double price = Double.parseDouble(in.get(in.size()-1));
	    
	    String description = "";
	     
	    for(int i=1; i<in.size()-2; i++)
	    	description = description.concat(" " + in.get(i));
	    description = description.substring(1);	

		return new Purchase(quantity, description, price);
	}
	
}
