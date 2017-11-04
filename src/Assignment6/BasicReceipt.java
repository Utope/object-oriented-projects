package Assignment6;

import java.sql.Date;

public class BasicReceipt implements Receipt {

	private String storeInfo;
	private String stateCode;
	private PurchasedItems items;
	private Date date;
	private TaxComputation tc;
	
	public BasicReceipt(PurchasedItems items) {
		this.items = items;
	}
	
	public void setTaxComputation(TaxComputation tc) {
		this.tc = tc;
	}
	
	//yyyy-mm-dd
	public void setDate(String date) {
		try {
			this.date = Date.valueOf(date);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void prtReceipt() {
		System.out.println(this.storeInfo + "\n");
		for(StoreItem item: items.getItems()) {
			System.out.println(item.getItemCode() + "-" + item.getItemDescription() + "-$" + item.getItemPrice());
		}
		
		System.out.println();
		
		if(tc != null) {
			System.out.println("Total - $" + items.getTotalCost());
			System.out.println("Total W/(Tax) - $" + (items.getTotalCost() + tc.computeTax(items, date)) + "\n");
		}else {
			System.out.println("Total - $" + items.getTotalCost() + "\n");
		}
		System.out.println(this.date + "\n");

	}
	
	public String getStoreInfo() {
		return this.storeInfo;
	}
	
	public String getStateCode() {
		return this.stateCode;
	}

	public PurchasedItems getItems() {
		return items;
	}

	public void setItems(PurchasedItems items) {
		this.items = items;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TaxComputation getTaxComputation() {
		return tc;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
}
