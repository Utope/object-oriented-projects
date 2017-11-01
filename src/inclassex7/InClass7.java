package inclassex7;

public class InClass7 {

	public static <T> void swap(T[] arr, int i, int j) {
		if(i < arr.length && j < arr.length) {
			
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
	}
	
	public static void main(String[] args) {
		String[] stringArray = {"One", "Two", "Three"};
		
		System.out.println("Before Swap...");
		
		for(int i = 0; i< stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
		InClass7.swap(stringArray, 0, 2);
		
		System.out.println("After Swap...");
		
		for(int i = 0; i< stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
		Integer[] integerArray = {1,2,3};
		
		System.out.println("Before Swap...");
		
		for(int i = 0; i< integerArray .length;i++) {
			System.out.println(integerArray[i]);
		}
		
		InClass7.swap(integerArray, 0, 2);
		
		System.out.println("After Swap...");
		
		for(int i = 0; i< integerArray .length;i++) {
			System.out.println(integerArray[i]);
		}
	

	}

}
