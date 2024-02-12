/*
 * Name: Tj Morrison
 * Date Updated: 11/27/2022
 * Description: Framework for typical Vending Machine Operations.
 * Sources Cited: NA
 * 
 * */

package application;

public class VendingMachine  implements VendingMachineInterface{
	private int[] itemStock = new int[3];
	private int vault_hand = 0;
	private int price = 0;
	private int vault = 0;
	
	public VendingMachine(int s, int t, int r) {
		//Set the initial stock number of each item in the machine.
		itemStock[0] = s;
		itemStock[1] = t;
		itemStock[2] = r;
	}
	
	public void insertCents(int c) {
		//Insert c cents into the machine
		if (c%5 == 0)
			vault_hand += c;
		else
			throw new ImproperCoinsException();
	}
	
	public void makeSelection(int s) {
		//Select an item by 0 (Snickers $1.00), 1 (Twix $1.15), or 2 (Reeses $1.30)
		if (s == 0)
			if (itemStock[0] != 0)
				price = 100;
			else
				throw new ImproperSelectionException("Snickers");
		else if (s == 1)
			if (itemStock[1] != 0)
				price = 115;
			else
				throw new ImproperSelectionException("Twix");
		else if (s == 2)
			if (itemStock[2] != 0)
				price = 130;
			else
				throw new ImproperSelectionException("Reeses");
		else
			throw new ImproperSelectionException();
	}
	
	public int purchaseSelection() {
		//Confirm purchase of made selection. (insertCents and makeSelection must be used first)
		if (price != 0) {
			if (vault_hand < price)
				throw new ImproperPurchaseException(price - vault_hand);
			vault += price;
			vault_hand -= price;
			if (price == 100)
				itemStock[0] -= 1;
			else if (price == 115)
				itemStock[1] -= 1;
			else if (price == 130)
				itemStock[2] -= 1;
			price = 0;
			int vault_out = vault_hand; //Swap to reset vault_hand for next input.
			vault_hand = 0;
			return vault_out;
		}
		else
			throw new ImproperPurchaseException();
		
	}
	
	public int returnUnspentCents() {
		//Return cents if you did not use purchaseSelection
		int vault_out = vault_hand; //Swap to reset vault_hand for next input.
		vault_hand = 0;
		return vault_out;
	}
	
	public int getProfits() {
		//Check Machine vault profits
		return vault;
	}

}
