
/* Author: Renee Linford
 * Date: 10-10-19
 * ADS Exercise 19-5: Maximum element in an array.
 */

public class Exercise19_5 {
	// Create and call max() method. 

	public static void main(String[] args) {
		// Declare integer, string, and circle arrays.

		Integer[] numbers = {1, 2, 3};
		System.out.println("The max is " + max(numbers));
		System.out.println();

		String[] words = {"red", "green", "blue"};
		System.out.println("The max is " + max(words));
		System.out.println();

		Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
		System.out.println("The max is " + max(circles));
		System.out.println();
	}

	static class Circle implements Comparable<Circle> {
		// Define circle class & implement Comparable. 

		double radius;
		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public int compareTo(Circle c) {
			if (radius < c.radius)
				return -1;
			else if (radius == c.radius)
				return 0;
			else
				return 1;
		}

		@Override
		public String toString() {
			return "Circle radius: " + radius;
		}
	}


	public static <E extends Comparable<E>> E max(E[] list) {
		// Method will return the max element in an array.

		// Define variables.
		E currentMax = list[list.length - 1];
		E currentMin = list[0];

		// Find the minimum in the list.		
		for (int i = 0; i < list.length - 1; i++) {
			
			// Set currentMin to first index.
			currentMin = list[i];
			int currentMinIndex = i;

			// Compare minimum value to next index.
			for (int j = i + 1; j < list.length; j++) {
				// If next index is less than current min value, currentMin changes. 
				if (currentMin.compareTo(list[j]) > 0) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			// If needed, swap list[i] with list[currentMinIndex].
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		currentMax = list[list.length - 1]; // Last index will be max value.
		return currentMax;
	}
}
