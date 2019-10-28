package exercise_24_5;

// ADS Exercise 24-5: Implement GenericQueue using composition

public class GenericQueue<E> {
	// GenericQueue by composition.

	private java.util.LinkedList<E> list = new java.util.LinkedList<>();

	public void enqueue(E e) {
		list.addLast(e);
	}

	public E dequeue() {
		return list.removeFirst();
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public String toString() {
		return "Queue: " + list.toString();
	}
}

