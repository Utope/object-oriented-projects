package Assignment6;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	
	public static String initMenu = "1 - Start New Receipt\n"
								+ 	"2 - Add items\n"
								+ 	"3 - Display Receipt";
	
	public static PurchasedItems items = new PurchasedItems();
	public static ReceiptFactory factory;
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<StoreItem> storeItems = new ArrayList<StoreItem>();
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
		
		System.out.println("Which State Store are you in?");
		System.out.println("1: Maryland");
		System.out.println("2: California");
		System.out.println("3: Massachusetts");
		System.out.println("4: Delaware");
		
		int choice = Integer.valueOf(scanner.nextLine());
		switch(choice) {
		case 1:
			factory = new ReceiptFactory("maryland.txt");
			break;
		case 2:
			factory = new ReceiptFactory("california.txt");
			break;
		case 3:
			factory = new ReceiptFactory("massachusetts.txt");
			break;
		case 4:
			factory = new ReceiptFactory("delaware.txt");
			break;
		default:
			factory = null;
		}
		
		storeItems.add(new StoreItem("432", "Desktop", "1200.00"));
		storeItems.add(new StoreItem("422", "Laptop", "99.99"));
		storeItems.add(new StoreItem("1406", "Bread", "3.00"));
		storeItems.add(new StoreItem("132", "Milk", "4.00"));
		
		mainMenu();
		
		
		

	}
	
	public static void mainMenu() {
		System.out.println(Client.initMenu);
		int choice2 = Integer.valueOf(scanner.nextLine());
		switch(choice2){
			case 1:
				System.out.println("Clearing PurchasedItems...\n");
				Client.items = null;
				Client.items = new PurchasedItems();
				mainMenu();
				break;
			case 2:
				boolean cont = true;
				
				while(cont) {
					for(int i = 0; i < Client.storeItems.size(); i++) {
						StoreItem item = storeItems.get(i);
						System.out.println( "[" + i + "]" + item.getItemPrice() + " - " + item.getItemDescription());
					}
					System.out.println("press inccorect key to go back");
					System.out.println("select an item:");
					int choice = Integer.valueOf(Client.scanner.nextLine());
					if(choice < storeItems.size() && choice > 0) {
						System.out.println("Adding " + storeItems.get(choice).getItemDescription());
						Client.items.addItem(storeItems.get(choice));
					}else {
						mainMenu();
					}
					
				}
				
				
				break;
			case 3:
				
				Receipt receipt = factory.getReceipt(items, Date.valueOf("2016-08-14"));
				receipt.prtReceipt();
				mainMenu();
				break;
		}
	}
}
