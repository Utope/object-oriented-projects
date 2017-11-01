package inclassex7;

public class OldType<T> {

	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t= t;
	}
	
	public static void main(String[] args) {
		OldType<String> type = new OldType<>();
		type.set("This is a string");
		String str = type.get();
		
		OldType<Integer> type2 = new OldType<>();
		type2.set(12345);
		int num = type2.get();

	}

}
