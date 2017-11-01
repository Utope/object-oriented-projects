package assignment5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Set<Integer> test = new SortedArraySet<Integer>(new ReverseSort());
		
		System.out.println("Random Numbers");
		Random rand = new Random();
		for(int i = 0; i < 15; i++) {
			test.add(rand.nextInt(100));
		}
		
		
		Iterator it = test.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Characters");
		
		Set<Character> test2 = new SortedArraySet<Character>(null);
		
		test2.add('c');
		test2.add('d');
		test2.add('e');
		test2.add('f');
		test2.add('f');
		test2.add('a');
		test2.add('b');
		
		Iterator it2 = test2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("Removing a b c e");
		
		test2.remove('a');
		test2.remove('b');
		test2.remove('c');
		test2.remove('e');
		
		Iterator it3 = test2.iterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
			
		
	}
}
