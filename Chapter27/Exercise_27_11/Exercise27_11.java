
/* Author: Renee Linford
 * Date: 10-30-19
 * ADS Exercise 27-11: (setToList) Write the following method that returns an ArrayList from a set. 
 */

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Exercise27_11 {

	public static void main(String[] args) {
		
		// Create new set & add strings.
		Set<String> set = new HashSet<String>();
		set.add("Smith");
		set.add("Anderson");
		set.add("Lewis");
		set.add("Cook");
		set.add("Smith");
		
		// Put set into an arrayList.
		ArrayList<String> list = setToList(set);
		System.out.println(list); // Print arrayList.
	}

	public static <E> ArrayList<E> setToList(Set<E> s) {
		// Method takes elements in a set and returns ArrayList with non-duplicate elements.
		
		// Create new arrayList.
		ArrayList<E> tempList = new ArrayList<>();
		
		// Add each element in set to arrayList.
		if (s.isEmpty()) {
			return tempList;
		}
		else {
		for (E element: s) { // For each element in set, check for duplicate in tempList.
			if (!tempList.contains(element)) { 
				tempList.add(element); // If not duplicate, add to arrayList.
			}
		}
		// Return non-duplicate element list.
		return tempList;
		
		}
	}

}
