package Assignment6;

public class Rebate1406 implements AddOn, Rebate{

	@Override
	public boolean applies(PurchasedItems items) {
		return items.containsItem("1406");
	}

	@Override
	public String getLines() {
		return "Mail-in Rebate for item #1406\n" + "Name:\n" + "Address:\n\n" + "Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL\n";
	}
	
}
