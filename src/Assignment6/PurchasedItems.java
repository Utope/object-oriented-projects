package Assignment6;

import java.util.ArrayList;

public class PurchasedItems {
	private ArrayList<StoreItem> items;
	
	public PurchasedItems() {
		this.items = new ArrayList<StoreItem>();
	}
	
	public void addItem(StoreItem item) {
		items.add(item);
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public double getTotalCost() {
		double totalCost = 0.0;
		for(StoreItem item: items) {
			totalCost = totalCost + Double.valueOf(item.getItemPrice());
		}
		return totalCost;
	}
	
	public boolean containsItem(String itemCode) {
		for(StoreItem item: items) {
			if(item.getItemCode().equals(itemCode)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<StoreItem> getItems(){
		return this.items;
	}
}
