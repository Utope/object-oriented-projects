package Assignment6;

import java.sql.Date;

public class MassachusettsTax extends TaxComputation {

	@Override
	public double computeTax(PurchasedItems items, Date date) {
		if(this.taxHoliday(date)) {
			return 0.0;
		}else {
			return items.getTotalCost() * 0.0625;
		}
	}

	@Override
	protected boolean taxHoliday(Date date) {
		Date[] taxHoliday = {
								Date.valueOf("2016-08-13"),
								Date.valueOf("2016-08-14")
							};
		
		for(Date holiday : taxHoliday) {
			if(date.equals(holiday)) {
				return true;
			}
		}
		
		return false;
	}

}
