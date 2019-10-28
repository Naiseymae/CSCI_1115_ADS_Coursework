
/* Author: Renee Linford
 * Date: 10-23-19
 * ADS Exercise 24-3: Implement a doubly linked list.
 */

public class Exercise24_3 {

	public static void main(String[] args) {
		
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();

		// System.out.print(iterator.next() + " ");

		System.out.println();
		while (iterator.hasPrevious())
				System.out.print(iterator.previous() + " ");
	}
}
