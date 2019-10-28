
/* Author: Renee Linford
 * Date: 10-22-19
 * ADS Exercise 24-1: Add set operations in MyList.
 */

public class Exercise24_1 {

	public static void main(String[] args) {
		// Define the methods addAll, removeAll, and retainAll in MyList and implement them in MyAbstractList. 
	  
		// Two MyArrayLists, list1 and list2, with the initial values.
		String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
	    String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
	    
	    // Create list1 and list2 with the initial values.
	    MyList<String> list1 = new MyArrayList<String>(name1);   
	    MyList<String> list2 = new MyArrayList<String>(name2);   
	    System.out.println("list1:" + list1);
	    System.out.println("list2:" + list2);
	    
	    // Invoke list1.addAll(list2), and display list1 and list2.
	    list1.addAll(list2);
	    System.out.println("After addAll list1:" + list1 + "\n");
	    
	    // Recreate list1 and list2 with the same initial values.
	    list1 = new MyArrayList<String>(name1);
	    list2 = new MyArrayList<String>(name2);   
	    System.out.println("list1:" + list1);
	    System.out.println("list2:" + list2);
	    
	    // Invoke list1.removeAll(list2), and display list1 and list2.
	    list1.removeAll(list2);
	    System.out.println("After removeAll list1:" + list1 + "\n");
	    
	    // Recreate list1 and list2 with the same initial values.
	    list1 = new MyArrayList<String>(name1);
	    list2 = new MyArrayList<String>(name2);   
	    System.out.println("list1:" + list1);
	    System.out.println("list2:" + list2);
	    
	    // Invoke list1.retainAll(list2), and display list1 and list2.
	    list1.retainAll(list2);
	    System.out.println("After retainAll list1:" + list1 + "\n");
		
	}
	
}
