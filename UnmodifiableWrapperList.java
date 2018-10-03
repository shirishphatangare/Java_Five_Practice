import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/* the unmodifiable wrappers take functionality away. In particular, they take away the ability to modify 
 * the collection by intercepting all the  
 * operations that would modify the collection and throwing an UnsupportedOperationException
 * USES - 
 * 1) To make a collection immutable once it has been built
 * 2) To allow certain clients read-only access to your data structures.
 */

public class UnmodifiableWrapperList {

	public static void main(String[] args) {
		List<String> list = Collections.unmodifiableList(new ArrayList<String>());
		//List<String> list = new ArrayList<String>(); // - Normal List
		//List<String> list = Collections.synchronizedList(new ArrayList<String>());
		
		list.add("Shirish"); // Throws UnsupportedOperationException for  unmodifiableList but NOT for normal/synchronizedList list
		
		System.out.println(list);

	}

}
