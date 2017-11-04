package Assignment6;

import java.sql.Date;

public class Client {
	
	/**
	 * 1.)Creates a PurchasedItems object.
	 * 2.)Constructs ReceiptFactory object.
	 * 3.)Prompts user for items to purchase, storing each in PurchasedItems.
	 * 4.)Calls the getReceipt method of the factory to obtain constructed receipt.
	 * 5.)Prints receipt by method call to constructed receipt.
	 * 
	 *get receipt date
	 *(prompt user for current date)
	 *
	 *display all available product to user
	 *(to be implemented)
	 *
	 *get all user selections
	 *(to be implemented)
	 * @param args
	 */
	public static void main(String[] args) {
		PurchasedItems items = new PurchasedItems();
		items.addItem(new StoreItem("432", "Computer", "100.01"));
		
		ReceiptFactory factory = new ReceiptFactory("maryland.txt");
		Receipt receipt = factory.getReceipt(items, Date.valueOf("2016-08-14"));
		receipt.prtReceipt();
	}
}
