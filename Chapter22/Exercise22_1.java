package exercise_22_1;

/* Author: Renee Linford
 * Date: 10-14-19
 * ADS Exercise 22-1: Maximum consecutive increasingly ordered substring.
 */

import java.util.*;

public class Exercise22_1 {

	public static void main(String[] args) {
		// This program that prompts the user to enter a string and 
		// displays the maximum consecutive increasingly ordered substring.
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: " );
		String string = input.next();
	
		System.out.println("Max substring: " + maxSubstring(string));
	}
	
	public static String maxSubstring(String string) {
		// Take string and split it. Place substrings into array.
		String s1 = string.toLowerCase();
		ArrayList<String> array = new ArrayList<>();
		
		int startIndex = 0;
		int endIndex = 0;
		int arrayIndex = 0;
		int maxIndex = 0;
		
		// Loop compares each character in string, & creates new substring.
		for (int i = 0; i < s1.length() - 1; i++) {
			
			//System.out.println("start index: " + startIndex + ", end index: " + endIndex);
			//for (int j = i + 1; j <= s1.length() - 1; j++) {
				//System.out.println("i = " + i);
	
				if (s1.charAt(i) < s1.charAt(i + 1)) {
					endIndex = i + 2;
				}
				if (s1.charAt(i) >= s1.charAt(i + 1)) {
					startIndex = i + 1;
					arrayIndex++;
				}
				array.add(s1.substring(startIndex, endIndex));
				//System.out.println("start index: " + startIndex + ", end index: " + endIndex);
		}
			
		//System.out.println(array);
		
		// Compare string length. Longest becomes new max.
		for (int j = 0; j < array.size() - 1; j++) {
			if ((array.get(j).length() < array.get(j + 1).length())) {
				maxIndex = j + 1;
				//System.out.println(array.get(maxIndex));
			}
		}
	
		// Return maxSubstring;
		return array.get(maxIndex);
	}

}


/*
 public static String maxSubstring(String string) {
		// Take string and split it. Place substrings into array.
		String s1 = string.toLowerCase();
		String[] array = new String[s1.length()];
		
		int startIndex = 0;
		int endIndex = 0;
		int arrayIndex = 0;
		int maxIndex = 0;
		
		// Loop compares each character in string, & creates new substring.
		for (int i = 0; i < s1.length() - 1; i++) {
			
			//System.out.println("start index: " + startIndex + ", end index: " + endIndex);
			//for (int j = i + 1; j <= s1.length() - 1; j++) {
				System.out.println("i = " + i);
	
				if (s1.charAt(i) < s1.charAt(i + 1)) {
					endIndex = i + 2;
				}
				if (s1.charAt(i) >= s1.charAt(i + 1)) {
					startIndex = i + 1;
					arrayIndex++;
				}
				array[arrayIndex] = s1.substring(startIndex, endIndex);
				System.out.println("start index: " + startIndex + ", end index: " + endIndex);
				System.out.println("array[" + arrayIndex + "]: " + array[arrayIndex]);
			}
			
		
		// Compare string length. Longest becomes new max.
		for (int j = 0; j < array.length - 1; j++) {
			if (((array[j]).compareTo(array[j + 1])) > 0) {
				maxIndex = j;
				System.out.println(array[maxIndex]);
			}
		}
	
		// Return maxSubstring;
		return array[maxIndex];
	}
			*/
