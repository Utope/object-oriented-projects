package assignment5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class SortedArraySet<AnyType> implements Set<AnyType> {

	
	private AnyType[] items;
	private int theSize;
	private java.util.Comparator<? super AnyType> comparator;
	
	public SortedArraySet(java.util.Comparator<? super AnyType> comparator) {
		this.comparator = comparator;
		this.theSize = 0;
		
		items = (AnyType[])new Object[5];
	}
	
	@Override
	public boolean isEmpty() {
		if(theSize == 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int getSize() {
		return theSize;
	}

	@Override
	public boolean add(AnyType x) {
		if(!this.contains(x)) {
			if(theSize == items.length) {
				AnyType[] temp = items.clone();
				
				items = (AnyType[]) new Object[theSize * 2];
				
				for(int i = 0; i < temp.length; i++) {
					items[i] = temp[i];
				}
				items[theSize++] = x;
				if(this.comparator != null) {
					Arrays.sort(items, 0 , theSize, this.comparator);
				}else {
					Arrays.sort(items, 0 , theSize);
				}
				return true;
			}else {
				items[theSize++] = x;
				if(this.comparator != null) {
					Arrays.sort(items, 0 , theSize, this.comparator);
				}else {
					Arrays.sort(items, 0 , theSize);
				}

				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(AnyType x) {
		for(int i = 0; i < theSize; i++) {
			if(this.compare(items[i], x) == 0) {
				if(i != theSize) {
					items[i] = items[theSize-1];
					theSize--;
					if(this.comparator != null) {
						Arrays.sort(items, 0 , theSize, this.comparator);
					}else {
						Arrays.sort(items, 0 , theSize);
					}
				}else {
					items[i] = null;
					theSize--;
					if(this.comparator != null) {
						Arrays.sort(items, 0 , theSize, this.comparator);
					}else {
						Arrays.sort(items, 0 , theSize);
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(AnyType x) {
		Iterator it = this.iterator();
		while(it.hasNext()) {
			if(this.compare((AnyType)it.next(), (AnyType)x) == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator iterator() {
		return new LocalIterator();
	}
	
	private class LocalIterator implements java.util.Iterator<AnyType>{
		
		int counter = 0;
		
		@Override
		public boolean hasNext() {
			if(counter < theSize) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public AnyType next() {
			return items[counter++];
		}
		
	}
	
	private int compare(AnyType lhs, AnyType rhs) {
		if(this.comparator != null) {
			return this.comparator.compare(lhs, rhs);
		}else {
			return ((Comparable)lhs).compareTo(rhs);
		}
		
	}

}
