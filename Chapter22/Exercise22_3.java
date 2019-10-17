package exercise_22_1;

/* Author: Renee Linford
 * Date: 10-14-19
 * ADS Exercise 22-3: Pattern matching in a string.
 */

import java.util.*;

public class Exercise22_3 {
	// Complexity: There is one for loop and two if statements, so the complexity is O(n).

	public static void main(String[] args) {
		// User to enter two strings.
		// Program tests whether the second string is a substring of the first string.

		// Prompt user for strings.
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first string: " );
		String s1 = input.nextLine();
		System.out.println("Enter second string: " );
		String s2 = input.nextLine();

		// Find if match exists.
		boolean match = false; 
		int index = 0;

		if (s1.contains(s2)) { // If s2 is in s1, then match = true.
			match = true;
			char ch = s2.charAt(0); // Character to match.
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == ch) {
					// When character in s2 matches s1, record index of match.
					index = i;
				}
			}
		}

		// Print if match is true or false.
		System.out.print("Match: " + match);
		if (match) System.out.print(" at index " + index);

	}
}
