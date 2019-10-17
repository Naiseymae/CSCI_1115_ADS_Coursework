
/* Author: Renee Linford
 * Date: 10-16-19
 * ADS Exercise 23-7: Min-Heap.
 */

public class Exercise23_7  {
	/* Revise Listing 23.9 to implement a minimum value as root of heap. */

	public static void main(String[] args) {
		// New int list.
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 

		// Call heapSort method and print sorted list.
		heapSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		// Heap sort method. 
		
		// Create a Heap of integers
		MinHeap<E> heap = new MinHeap<>();

		// Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);

		// Remove elements from the heap
		for (int i = 0; i < list.length; i++)
			list[i] = heap.remove();
	}
	
}
