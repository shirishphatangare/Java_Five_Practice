import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;



// ConcurrentHashMap to avoid ConcurrentModificationException in HashMap
public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<String,String>();
		
		//HashMap<String,String> hashMap = new HashMap<String,String>();
		
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		hashMap.put("4", "4");
		
		Iterator<String> it = hashMap.keySet().iterator();
		
		while(it.hasNext()){
			hashMap.put("4", "44"); // No ConcurrentModificationException even for normal HashMap, since we are not changing structure of Hashmap. Just update to existing value
			hashMap.put("5", "44"); // ConcurrentModificationException for normal HashMap but not for ConcurrentHashMap
			System.out.println(it.next());
		}
		System.out.println(hashMap);

	}

}
