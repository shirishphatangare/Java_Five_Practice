import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> linkList = new LinkedList<String>();
		List<String> familyFriends1 = new ArrayList<String>();
        familyFriends1.add("Jesse");
        familyFriends1.add("Walt");
        
        List<String> familyFriends2 = new ArrayList<String>();
        familyFriends2.add("Jabu");
        familyFriends2.add("Sabu");
		
		linkList.add("Shirish");
		linkList.add("Sweta");
		linkList.add("Sneha");
		linkList.add("Shreyas");
		
		// Add element at specific index
		linkList.add(2, "Vitthal");
		linkList.addFirst("Nana");
		linkList.addLast("Dada");
		
		// Add whole collection 
		linkList.addAll(familyFriends1);
		
		// Add whole collection at specific index
		linkList.addAll(4,familyFriends2);
		
		System.out.println(linkList);
		
		//get the first element in the LinkedList.
		System.out.println("First - " + linkList.getFirst());
		
		//get the last element in the LinkedList.
		System.out.println("Last - " + linkList.getLast());
		
		//get the element at specific index in the LinkedList.
		System.out.println("At Index 6 - " + linkList.get(6) );
	
		//remove the first element in the LinkedList
		System.out.println("Remove the first element - " + linkList.removeFirst());

		//remove the last element in the LinkedList
		System.out.println("Remove the last element - " + linkList.removeLast());
		
		linkList.removeFirstOccurrence("Sweta");
		System.out.println(linkList);
		System.out.println(linkList.contains("Dada"));
		System.out.println(linkList.containsAll(familyFriends2));
		System.out.println(linkList.indexOf("Jabu"));
		System.out.println(linkList.lastIndexOf("Vitthal"));
		//linkList.clear();
		System.out.println(linkList);

	}
	
}
