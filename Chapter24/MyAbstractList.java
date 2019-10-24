
/* ADS Exercise 24-1:  MyAbstractList abstract class */

public abstract class MyAbstractList<E> implements MyList<E> {
	
	protected int size = 0; /** The size of the list. */

	/** Create a default list. */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects. */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list. */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list. */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
	
	/* Adds the elements in otherList to this list. */
	// Returns true if this list changed as a result of the call. 
	@Override
	public boolean addAll(MyList<E> otherList) {
		
		boolean changed = false;
		
		// Add elements of otherList to first list.
		for (int i = 0; i < otherList.size(); i++) {
			if (!this.contains(otherList.get(i)))
				this.add(otherList.get(i));
				changed = true; // If any elements added to this list, changed = true.
		}	
		return changed;
	}

	/* Removes all the elements in otherList from this list. */
	// Returns true if this list changed as a result of the call.
	public boolean removeAll(MyList<E> otherList) {
		
		boolean changed = false;
		
		// Remove elements in otherList from first list.
		for (int i = 0; i < otherList.size(); i++) {
			if (this.contains(otherList.get(i)))
				this.remove(otherList.get(i));
				changed = true; // If any elements added to this list, changed = true.
		}	
		return changed;
	}

	/* Retains the elements in this list that are also in otherList. */
	// Returns true if this list changed as a result of the call 
	public boolean retainAll(MyList<E> otherList) {
		
		boolean changed = false;
		MyList<E> temp = new MyArrayList<E>(); // Create temp list.
		
		// Keep elements in first list that are also in otherlist.
		for (int i = 0; i < otherList.size(); i++) {
			if (this.contains(otherList.get(i)))
				temp.add(otherList.get(i)); // Add to temp only if in both lists.
				changed = true; // If any elements added to this list, changed = true.
		}	
		
		// Clear this list & add contents of temp list.
		this.clear();
		for (int j = 0; j < temp.size(); j++) {
			this.add(temp.get(j));
		}
		
		return changed;
	}
}
