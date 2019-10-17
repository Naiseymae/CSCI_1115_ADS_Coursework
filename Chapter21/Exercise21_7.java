
/* Author: Renee Linford
 * Date: 10-14-19
 * ADS Exercise 21-7: Revise Listing 21.9 - Word Occurrence
 */

import java.util.*;

public class Exercise21_7<E> {

	public static void main(String[] args) {

		// Write text in a string.
		String text = "Good morning. Have a good class. " +
				"Have a good visit. Have fun!";

		// Create a HashMap to hold words as the key and count as the value.
		Map<String, Integer> map = new HashMap<>();
		String[] words = text.split("[\\s+\\p{P}]");

		// Put words into map as keys.
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			//System.out.println("key: " + key);
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else { // Increase value each time word occurs.
					int value = map.get(key);
					value++;
					map.put(key, value);
				}				
			}
		}

		// Display key and value for each entry
		//map.forEach((k, v) -> System.out.println(k + "\t" + v));

		// Print map as arrayList.
		ArrayList <WordOccurrence> sortedList = sort(map);

		for (WordOccurrence wo: sortedList) {
			System.out.print(wo.word + ": ");
			System.out.println(wo.count);
		}
	}

	public static ArrayList<WordOccurrence> sort(Map<String, Integer> map) {
		// This method takes a map and sorts it based on count value.
		ArrayList<WordOccurrence> myList = new ArrayList<>();

		// Add each WordOccurence object into ArrayList.
		for (String key: map.keySet()) {
			myList.add(new WordOccurrence(key, (int) map.get(key)));
		}

		Collections.sort(myList); // Sort ArrayList
		return myList; // Return ArrayList
	}
}

class WordOccurrence implements Comparable<WordOccurrence> {

	// Variables
	String word;
	int count = 0;

	// Constructor
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}

	// New compareTo method; compares the count value for a word.
	@Override
	public int compareTo(WordOccurrence word) {
		int w1 = this.count;
		int w2 = word.count;
		if (w1 < w2) 
			return -1;
		else if (w1 == w2) 
			return 0;
		else
			return 1;
	}

}
