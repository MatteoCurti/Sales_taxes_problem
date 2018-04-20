import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import round.Round;
import salesTaxesProgram.Purchase;

public class SalesTaxProgram {

	public static void main(String[] args) {
		String file;
		
		if (args.length != 2) {
			BufferedReader bsr = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Inserisci il nome del file di input: ");
			try {
				file = bsr.readLine();
			} catch (IOException e) {
				file = "input0.txt";
				e.printStackTrace();
			}
		} 	
		else file = args[1];
		
		ArrayList<Purchase> al = new ArrayList<Purchase>();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String string;
		    while ((string = in.readLine()) != null)
		    	if (!string.isEmpty())
		    		al.add(Purchase.parse(string)); 
		    in.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		
		Purchase p;
		double totalPrice = 0.0;
		double totalWithTax = 0.0;
		for(int i = 0 ; i < al.size() ; i++) {
			p = al.get(i);
			System.out.println(p.getQuantity()+" "+p.getDescription()+": "+p.getPricePurchase());
			totalPrice += p.getPrice() * p.getQuantity();
			totalWithTax += Double.parseDouble(p.getPricePurchase());
		}
		System.out.println("Sales Taxes: " + Round.format(totalWithTax - totalPrice));
		System.out.println("Total: " + Round.format(totalWithTax));
	}

}