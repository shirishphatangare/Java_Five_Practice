import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		
		LinkedHashMap<String,String> lhm = new LinkedHashMap<String,String>();
		
		lhm.put("one", "A");
		lhm.put("two", "B");
		lhm.put("Three", "C");
		lhm.put("one", "AA");
		lhm.put(null, null);
		lhm.put(null, null);
		lhm.put("Four", "D");
		
		System.out.println(lhm);
		
		System.out.println(lhm.get("two"));
		System.out.println(lhm.get("Two"));
		
		for(Map.Entry<String,String> e:   lhm.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		

	}

}
