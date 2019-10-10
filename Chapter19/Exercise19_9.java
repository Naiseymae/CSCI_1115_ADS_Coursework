package excercise_19_9;

/* Author: Renee Linford
 * Date: 10-9-19
 * ADS Exercise 19-9: Sort ArrayList
 */

import java.util.ArrayList;

public class Exercise19_9 {
	public static void main(String[] args) {
		// Create ArrayList & sort contents.

		// New ArrayList.
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);

		// Call sort method.
		Exercise19_9.<Integer>sort(list);
		System.out.print(list);
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		// Find the minimum in the list.
		
		// Create variables for minimum value & index.
		E currentMin;
		int currentMinIndex;

		// Loop compares each index to minimum value.
		for (int i = 0; i < list.size() - 1; i++) {
			
			// Variables for sorting min/max
			currentMin = list.get(i);
			currentMinIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				// Compare minimum value to next index.
				// If next index is less than current min value, currentMin changes. 
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			// If needed, swap list[i] with list[currentMinIndex].
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}

		}

	}
}
