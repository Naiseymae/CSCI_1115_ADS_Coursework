
/* Author: Renee Linford
 * Date: 10-30-19
 * ADS Exercise 27-9: Implement hashCode for string
 */

public class Exercise27_9 {

	public static void main(String[] args) {
		// Write a method that returns a hashcode for a string.

		/*
		Given: "4.5"      Expected: 51451
		Given: "Hello"    Expected: 69609650
		 */

		String s1 = "4.5";
		System.out.println(hashCodeForString(s1));

		String s2 = "Hello";
		System.out.println(hashCodeForString(s2));
	}

	public static int hashCodeForString(String s) {
		// Hash code for strings with b value of 31
		// (… ( ( s0 * b + s1 ) b + s2 ) b + … + sn−2 ) b + sn−1
		int b = 31;
		int n = 1;

		// Initial hashCode = s0 * b + s1
		int hashCode = (s.charAt(n - 1) * b) + s.charAt(n);

		for (int i = 2; i < s.length(); i++) {
			// Loop continues to add to hashCode for length of string.
			hashCode = (hashCode * b) + s.charAt(i);
		}

		return hashCode;

	}


}
