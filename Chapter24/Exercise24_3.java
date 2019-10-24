
/* Author: Renee Linford
 * Date: 10-23-19
 * ADS Exercise 24-3: Implement a doubly linked list.
 */

public class Exercise24_3 {

	public static void main(String[] args) {
		
		// New linked list & add integers to list.
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		// New iterator for linked list.
		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();

		// System.out.print(iterator.next() + " ");

		// Print while iterator has previous node in list.
		System.out.println();
		while (iterator.hasPrevious())
				System.out.print(iterator.previous() + " ");
	}
}
