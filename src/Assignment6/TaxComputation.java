package Assignment6;

public abstract class TaxComputation {
	public abstract double computeTax(PurchasedItems items, ReceiptDate date);
	public abstract boolean taxHoliday();
}
