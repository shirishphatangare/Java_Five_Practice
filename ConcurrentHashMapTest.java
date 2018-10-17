import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



// ConcurrentHashMap to avoid ConcurrentModificationException in HashMap
public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		//ConcurrentHashMap<String,String> conHashMap = new ConcurrentHashMap<String,String>();
		
		HashMap<String,String> hashMap = new HashMap<String,String>();
		Map<String,String> syncHashMap = Collections.synchronizedMap(hashMap);
		
		syncHashMap.put("1", "1");
		syncHashMap.put("2", "2");
		syncHashMap.put("3", "3");
		syncHashMap.put("4", "4");
		
		Iterator<String> it = syncHashMap.keySet().iterator();
		
		while(it.hasNext()){
			syncHashMap.put("4", "44"); // No ConcurrentModificationException even for normal HashMap and synchronizedMap, since we are not changing structure of Hashmap. Just update to existing value
			syncHashMap.put("5", "44"); // ConcurrentModificationException for normal HashMap and synchronizedMap but not for ConcurrentHashMap
			System.out.println(it.next());
		}
		System.out.println(syncHashMap);

	}

}
