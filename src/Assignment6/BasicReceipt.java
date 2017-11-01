package Assignment6;

public class BasicReceipt implements Receipt {

	private String storeInfo;
	private String stateCode;
	private PurchasedItems items;
	private String date;
	private TaxComputation tc;
	
	public BasicReceipt(PurchasedItems items) {
		this.items = items;
	}
	
	public void setTaxComputation(TaxComputation tc) {
		this.tc = tc;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public void prtReceipt() {
		// TODO Auto-generated method stub
		
	}
	
}
