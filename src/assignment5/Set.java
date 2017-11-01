package assignment5;

public interface Set<AnyType> extends Iterable<AnyType> {
	/**
	 * returns true if there are no elements in the set
	 * 
	 * @return boolean
	 */
	boolean isEmpty();
	
	/**
	 * returns the number of elements in the set
	 * @return
	 */
	int getSize();
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	boolean add(AnyType x);
	
	/**
	 * removes x from the set if it was present, and does nothing otherwise. Returns a boolean
	 * indicating if the operation was succesful
	 * @param x
	 * @return
	 */
	boolean remove(AnyType x);
	
	/**
	 * returns true if and only if x is in the set
	 * @param x
	 * @return
	 */
	boolean contains(AnyType x);
	
	/**
	 * returns an iterator object that implements the standard java.util.iterator interface
	 */
	java.util.Iterator<AnyType> iterator();
}
