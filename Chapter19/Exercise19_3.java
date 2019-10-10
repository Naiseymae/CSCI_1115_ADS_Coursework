
/* Author: Renee Linford
 * Date: 10-8-19
 * ADS Exercise 19-3: Distinct elements in ArrayList
 */

import java.util.ArrayList;

public class Exercise19_3 {
	// Calls removeDuplicates method for integer ArrayList.

	public static void main(String[] args) {

		// Create new ArrayList & add integers to list.
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);

		// Call removeDuplicates method and print list.
		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.print(newList);
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)  {
		// Method removes duplicate elements from ArrayList.

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j); // Removes duplicate index.
				}
			}
		}
		return list; 
	}

}
