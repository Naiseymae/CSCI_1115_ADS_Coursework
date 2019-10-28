
/* Author: Renee Linford
 * Date: 10-23-19
 * ADS Exercise 24-5: Implement GenericQueue using composition
 */

public class Exercise24_5 {

	public static void main(String[] args) {
		// Define a new queue class that extends java.util.LinkedList. 
		
		// Create a queue.
		GenericQueue<String> queue = new GenericQueue<>();

		// Use enqueue to add to list.
		queue.enqueue("red");
		queue.enqueue("orange");
		queue.enqueue("yellow");
		queue.enqueue("green");
		queue.enqueue("blue");
		queue.enqueue("indigo");
		queue.enqueue("violet");
		
		// Print size of list.
		System.out.println("List size is " + queue.getSize());
		
		// Use dequeue to remove from list.
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	
		// Print list contents.
		System.out.println("After dequeue, remaining " + queue.toString());
		
	}

}
