
/* Author: Renee Linford
 * Date: 10-10-19
 * ADS Exercise 20-21: Use Comparator for Array
 */

import java.util.Comparator;

public class Exercise20_21 {

	public static void main(String[] args) {

		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
				new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
				new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
				new Circle(6.5), new Rectangle(4, 5)};
		
		
		Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
				new Circle(5), new Circle(6), new Circle(1), new Circle(2),
				new Circle(3), new Circle(14), new Circle(12)};
		
		// Sort selection list.
		selectionSort(list, new GeometricObjectComparator());

		// Print list.
		for (int i = 0; i < list.length; i++) {
			System.out.println("list[" + i + "] = " + list[i].getArea() + " ");
		}
	}

	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {

		// Define variables. 
		E currentMin;
		int currentMinIndex;
		
		// Sort list in ascending order, according to area size.		
		for (int i = 0; i < list.length - 1; i++) {

			// Variables for sorting min/max
			currentMin = list[i];
			currentMinIndex = i;
			
			//System.out.println(list[i]);

			// Compare minimum value to next index.
			for (int j = i + 1; j < list.length; j++) {
				// If next index is less than current min value, currentMin changes. 
				if (comparator.compare(currentMin, list[j]) > 0) {
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
	}
}
