import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashSetTest {

	public static void main(String[] args) {
		Map<String, Boolean> hashMap = new ConcurrentHashMap<String, Boolean>();
		Set<String> mySet = Collections.newSetFromMap(hashMap);
		//Set<String> mySet = new HashSet<String>();
		
		mySet.add("1");
		mySet.add("2");
		mySet.add("3");
		mySet.add("4");
		
		
		Iterator<String> iter = mySet.iterator();
		
		while(iter.hasNext()){
			mySet.add("5"); // ConcurrentModificationException for normal Set but not from set derived from ConcurrentHashMap
			System.out.println(iter.next());
		}
		
		
		
		//System.out.println(mySet);
		

	}

}
