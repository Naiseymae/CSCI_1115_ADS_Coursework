
/* Author: Renee Linford
 * Date: 10-9-19
 * ADS Exercise 20-3: Guessing the Captials v2
 */

import java.util.*;

public class Exercise20_3 {
	/* Pairs of states and capitals are displayed so that the 
	 * questions are displayed randomly. */

	public static void main(String[] args) {
		String[][] stateCapital = {  // State/capital list
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"},
				{"Connecticut", "Hartford"},
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"},
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"},
				{"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Indiana", "Indianapolis"},
				{"Iowa", "Des Moines"},
				{"Kansas", "Topeka"},
				{"Kentucky", "Frankfort"},
				{"Louisiana", "Baton Rouge"},
				{"Maine", "Augusta"},
				{"Maryland", "Annapolis"},
				{"Massachusettes", "Boston"},
				{"Michigan", "Lansing"},
				{"Minnesota", "Saint Paul"},
				{"Mississippi", "Jackson"},
				{"Missouri", "Jefferson City"},
				{"Montana", "Helena"},
				{"Nebraska", "Lincoln"},
				{"Nevada", "Carson City"},
				{"New Hampshire", "Concord"},
				{"New Jersey", "Trenton"},
				{"New York", "Albany"},
				{"New Mexico", "Santa Fe"},
				{"North Carolina", "Raleigh"},
				{"North Dakota", "Bismarck"},
				{"Ohio", "Columbus"},
				{"Oklahoma", "Oklahoma City"},
				{"Oregon", "Salem"},
				{"Pennsylvania", "Harrisburg"},
				{"Rhode Island", "Providence"},
				{"South Carolina", "Columbia"},
				{"South Dakota", "Pierre"},
				{"Tennessee", "Nashville"},
				{"Texas", "Austin"},
				{"Utah", "Salt Lake City"},
				{"Vermont", "Montpelier"},
				{"Virginia", "Richmond"},
				{"Washington", "Olympia"},
				{"West Virginia", "Charleston"},
				{"Wisconsin", "Madison"},
				{"Wyoming", "Cheyenne"}
		};
		
		Scanner input = new Scanner(System.in);
		int correctCount = 0; // Counter for correct answers.
		
		// Create arrayList to shuffle cities
		ArrayList<Integer> intList = new ArrayList<>();
		for (int j = 0; j < stateCapital.length; j++) {
			intList.add(j);
		}
		
		// Shuffle the integers in intList array.
		Collections.shuffle(intList); 
		
		for (int i = 0; i < stateCapital.length; i++) {
			// Prompt the user with a question
			
			// Use random intList to ask questions.
			System.out.print("What is the capital of " + stateCapital[intList.get(i)][0] + "? ");
			String capital = input.nextLine().trim().toLowerCase();
			
			if (capital.toLowerCase().equals(stateCapital[intList.get(i)][1].toLowerCase())) 
			{
				System.out.println("Your answer is correct.\n");
				correctCount++;
			}
			else
				System.out.println("The correct answer should be " + stateCapital[intList.get(i)][1] + ".\n");
		}
		
		// Print the number of correct answers.
		System.out.println("The correct count is " + correctCount + ".\n");

	}

}
