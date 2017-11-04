package Assignment6;

public class Coupon100Get10Percent implements AddOn, Coupon {

	@Override
	public boolean applies(PurchasedItems items) {
		if(items.getTotalCost() > 100.0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String getLines() {
		return "Spent over $100! 10% Off next Purchase!\n";
	}

}
