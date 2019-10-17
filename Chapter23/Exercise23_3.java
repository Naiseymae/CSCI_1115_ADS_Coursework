package exercise_23_3;

/* Author: Renee Linford
 * Date: 10-16-19
 * ADS Exercise 23-3: Generic quick sort.
 */

import java.util.Comparator;

public class Exercise23_3 {

	public static void main(String[] args) {
		//** Sort two lists: one with a method using comparable interface, & one with a method using comparator interface. */
		
		// Create int list and call quickSort method.
		Integer[] list1 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		
		// Call quickSort comparable method.
		quickSort(list1);

		// Print sorted list.
		for (int i = 0; i < list1.length; i++) {
			System.out.print(list1[i] + " ");
		}
		System.out.println();
	
		// Create circle list and call quickSort method.
		Circle[] list2 = {new Circle(2), new Circle(3), new Circle(2),
				new Circle(5), new Circle(6), new Circle(1), new Circle(2),
				new Circle(3), new Circle(14), new Circle(12)};

		// Call quickSort comparator method.
		quickSort(list2, new GeometricObjectComparator());

		// Print sorted list.
		for (int i = 0; i < list2.length; i++) {
			System.out.println(list2[i] + " ");
		}
	}

	//** Comparable methods */

	public static <E extends Comparable<E>> void quickSort(Integer[] list) {
	// This quickSort method uses comparable to sort list.
		quickSort(list, 0, list.length - 1); // Recursive quickSort call.
	}

	public static void quickSort(Integer[] list, int first, int last) {
		// This quickSort helper method uses comparable to sort list.
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1); // Recursive quickSort call: 2nd portion of list.
			quickSort(list, pivotIndex + 1, last); // Recursive quickSort call: 2nd portion of list.	
		}
	}
	
	public static int partition(Integer[] list, int first, int last) {
		/* Partition method for quickSort comparable.
		 * Method will partition the array list[first..last] */
		
		int pivot = list[first]; // Choose the first element as the pivot.
		int low = first + 1; // Index for forward search.
		int high = last; // Index for backward search.

		while (high > low) {
			// Search from the left forward.
			while (low <= high && (list[low].compareTo(pivot) <= 0)) {
				low++;
			}
			// Search from the right backward.
			while (low <= high && (list[high].compareTo(pivot) > 0)) {
				high--;
			}
			// Swap two elements in the list.
			if (high > low) {
				int temp = list[high]; 
				list[high] = list[low];
				list[low] = temp;
			}
		}
		// Move high index right backward.
		while (high > first && (list[high].compareTo(pivot)) >= 0) {
			high--;
		}

		// Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot; 
			return high;
		}
		else {
			return first;
		}
	}

	//** Comparator methods */
	
	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		// This quickSort method uses comparators to sort list.
		quickSort(list, 0, list.length - 1, comparator);
	}
	
	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
		// This quickSort helper method uses comparators to sort list.
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator);
			quickSort(list, first, pivotIndex - 1, comparator); // Recursive quickSort call: 2nd portion of list.
			quickSort(list, pivotIndex + 1, last, comparator); // Recursive quickSort call: 2nd portion of list.
		}
	}

	public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
		/* Partition method for quickSort comparator.
		 * Method will partition the array list[first..last] */

		E pivot = list[first]; // Choose the first element as the pivot.
		int low = first + 1; // Index for forward search.
		int high = last; // Index for backward search.

		while (high > low) {
			// Search from the left forward.
			while (low <= high && (comparator.compare(list[low], pivot) <= 0)) {
				low++;
			}
			// Search from the right backward.
			while (low <= high && (comparator.compare(list[high], pivot) > 0)) {
				high--;
			}
			// Swap two elements in the list.
			if (high > low) {
				E temp = list[high]; 
				list[high] = list[low];
				list[low] = temp;
			}
		}
		// Move high index right backward.
		while (high > first && (comparator.compare(list[high], pivot)) >= 0) {
			high--;
		}

		// Swap pivot with list[high]
		if (comparator.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot; 
			return high;
		}
		else {
			return first;
		}
	}

}
