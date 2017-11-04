package Assignment6;

import java.sql.Date;

public class MarylandTax extends TaxComputation {
	
	/**
	 * calls private method taxHoliday as part of this computation
	 */
	@Override
	public double computeTax(PurchasedItems items, Date date) {
		if(this.taxHoliday(date)) {
			return 0.0;
		}else {
			return items.getTotalCost() * 0.06;
		}
	}

	/*
	 * returns true if date of receipt within the state’s tax free holiday,
	 * else returns false. Supporting method of method computeTax.
	 */
	@Override
	public boolean taxHoliday(Date date) {
		return false;
	}
	
}
