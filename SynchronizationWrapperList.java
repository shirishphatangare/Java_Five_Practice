import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SynchronizationWrapperList {

	public static void main(String[] args) {
		
		//  If a thread modifies an ArrayList structurally (add OR delete) and multiple threads access it concurrently, 
		// it must be synchronized externally.
		List<String>threadSafeList = Collections.synchronizedList(new ArrayList<String>());
		
		threadSafeList.add("Dada");
		threadSafeList.add("Baba");
		threadSafeList.add("Nana");
		threadSafeList.add("Kaka");
		threadSafeList.add("Caca");
		
		// In the face of concurrent access, it is imperative that user manually synchronize on the returned list when iterating over it.
		// The reason is that iteration is accomplished via multiple calls into the collection, which must be composed into a single atomic operation.
		synchronized (threadSafeList) {
			Iterator<String> iter = threadSafeList.iterator();
			
			while(iter.hasNext()){
				System.out.println(iter.next());
			}
		}
	}
}
