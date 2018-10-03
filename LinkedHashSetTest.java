import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("A");
		lhs.add("F");
		lhs.add("C");
		lhs.add("D");
		lhs.add("E");
		
		lhs.add("E");
		
		System.out.println(lhs);
		
		List<String> str = new ArrayList<String>();
		str.add("AA");
		str.add("BB");
		str.add("CC");
		str.add("DD");
		str.add("CC");
		
		lhs.addAll(str);
		System.out.println(lhs);
		
		lhs.retainAll(str);
		
		Iterator<String> it = lhs.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//System.out.println(lhs);

	}

}
