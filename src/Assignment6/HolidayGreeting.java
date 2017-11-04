package Assignment6;

public class HolidayGreeting implements AddOn, Greeting, SecondaryHeading {

	@Override
	public boolean applies(PurchasedItems items) {
			return true;
	}

	@Override
	public String getLines() {
		return "* Happy Holidays from Best Buy *";
	}

}
