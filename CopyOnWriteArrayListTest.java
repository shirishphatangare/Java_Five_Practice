import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


/*A thread-safe variant of ArrayList in which all mutative operations (e.g. add, set, remove..) 
 * are implemented by creating a separate copy of underlying array. It achieves thread-safety by 
 * creating a separate copy of List which is a is different way than vector or other collections 
 * use to provide thread-safety. */

public class CopyOnWriteArrayListTest {

	//It is costly as it involves separate Array copy with every write operation (e.g. add, set, remove..)
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		//List<String>list = Collections.synchronizedList(new ArrayList<String>());
		//List<String> list = new ArrayList<String>();
		
		// Both commented lists above normal list and synchronized list gives ConcurrentModificationException.
		// Only way is to use CopyOnWriteArrayList class to avoid ConcurrentModificationException
		list.add("Dada");
		list.add("Baba");
		list.add("Nana");
		list.add("Kaka");
		list.add("Caca");
		
		Iterator<String> iter = list.iterator();
		
		// java.util.ConcurrentModificationException is thrown in case of normal ArrayList - Addition and traversal of List at the same time
		// CopyOnWriteArrayList prevents ConcurrentModificationException
		while(iter.hasNext()){
			String element = iter.next();
			System.out.println(element);
			
			/*Iterator does not throw ConcurrentModificationException even if copyOnWriteArrayList is modified once iterator is created because iterator is iterating 
			 * over the separate copy of ArrayList while write operation is happening on another copy of ArrayList.
			 */
			list.add("ddd");
			
			/*It throws UnsupportedOperationException if you try to modify CopyOnWriteArrayList 
			 * through iterator’s own method(e.g. add(), set(), remove()).
			 */
			//iter.remove(); 
		}
		
		
		
		System.out.println(list);
	}

}
