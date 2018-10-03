import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest1 {

	public static void main(String[] args) {
		TreeMap<String, String> tm = new TreeMap<String,String>();
		
		tm.put("one", "A");
		tm.put("two", "B");
		tm.put("Three", "C");
		tm.put("one", "AAAA");
		
		System.out.println(tm);
		
		Entry<String,String> entry = tm.pollFirstEntry();
		
		System.out.println(entry.getValue());
		System.out.println(entry.getKey());
		
		for(Entry<String,String> e: tm.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}

	}

}
