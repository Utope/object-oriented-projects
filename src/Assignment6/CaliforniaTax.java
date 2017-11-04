package Assignment6;

import java.sql.Date;

public class CaliforniaTax extends TaxComputation {

	@Override
	public double computeTax(PurchasedItems items, Date date) {
		if(this.taxHoliday(date)) {
			return 0.0;
		}else {
			return items.getTotalCost() * 0.075;
		}
	}

	@Override
	protected boolean taxHoliday(Date date) {
		return false;
	}

}
