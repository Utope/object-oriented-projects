package Assignment6;

import java.sql.Date;

public abstract class TaxComputation {
	public abstract double computeTax(PurchasedItems items, Date date);
	protected abstract boolean taxHoliday(Date date);
}
