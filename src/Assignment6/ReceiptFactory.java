package Assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class ReceiptFactory {
	String header; // contains line with "Best Buy", store_num, street_addr, phone
	String state_code;
	
	private HashMap<String, TaxComputation> taxComputationObjs; // tax computation objects (for each state)
	private ArrayList<AddOn> addOns; //secondary header, rebate and coupon add-ons
	
	/*
	 * 1.)populates array of StateCompuitation objects and array of AddOn objects(as if downloaded from the BestBuy web site)
	 * 2.)Reads config file to assign store_num, street_addr, etc
	 * 3.)Based on the state code (e.g., "MD", from the config file) stores appropriate StateComputation object to be used on all receipts
	 */
	public ReceiptFactory(String fileName) {
		taxComputationObjs = new HashMap<>();
		addOns = new ArrayList<>();
		
		this.taxComputationObjs.put("MD", new MarylandTax());
		this.taxComputationObjs.put("CA", new CaliforniaTax());
		this.taxComputationObjs.put("MA", new MassachusettsTax());
		this.taxComputationObjs.put("DE", null);
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			
			//Format of file
			//header
			//state_code
			//addOns
			
			this.header = bufferedReader.readLine();
			this.state_code = bufferedReader.readLine();
			
			String addon = null;
			while((addon = bufferedReader.readLine()) != null) {
				switch(addon) {
				case "Coupon100Get10Percent":
					addOns.add(new Coupon100Get10Percent());
					break;
				case "HolidayGreeting":
					addOns.add(new HolidayGreeting());
					break;
				case "Rebate1406":
					addOns.add(new Rebate1406());
					break;
				}
			}
			
			bufferedReader.close();
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * 1.)set the current date of the BasicReceipt
	 * 2.)Attaches the StateComputation object to the BasicReceipt(by call to the setComputation method of BasicReceipt).
	 * 3.)Traverses over all AddOn objects, calling the applies method of each. If an AddOn object appiles,
	 * then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon. If of type SecondaryHeader, then creates a PreDecorator for the other AddOn.
	 * If of type Rebate or Coupon, then creates a PostDecorator
	 * 4.)Links in the decorator object based on the Decorator design pattern.
	 * 5.)Adds current date to
	 * 6.)Returns decorated BasicReceipt object as type Receipt
	 * @param items
	 * @return BasicReceipt
	 */
	public Receipt getReceipt(PurchasedItems items, Date date) {
		BasicReceipt receipt = new BasicReceipt(items);
		receipt.setDate(date);
		receipt.setStateCode(this.state_code);
		receipt.setStoreInfo(this.header);
		receipt.setTaxComputation(this.taxComputationObjs.get(this.state_code));
		
		Decorator dec = null;
		for(AddOn addOn : this.addOns) {
			if(addOn.applies(items)) {
				if(addOn instanceof SecondaryHeading) {
					if(dec == null) {
						dec = new PostDecorator(addOn, receipt);
					}else {
						dec = new PostDecorator(addOn, dec);
					}
				}else {
					if(dec == null) {
						dec = new PreDecorator(addOn, receipt);
					}else {
						dec = new PreDecorator(addOn, dec);	
					}
				}
			}
		}
		
		return (Receipt)dec;
		
	}
}
