import java.util.Arrays;
import java.util.List;


public class GenericsUnBoundedWildCardTest {
	
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(4,3,2,15,53);
		displayResults(list1);
		
		List<Double> list2 = Arrays.asList(4.4,3.2,2.3,15.2,53.3);
		displayResults(list2);
		
		List<String> list3 = Arrays.asList("4","73","2F","1Y5","TT53");
		displayResults(list3);
	}
	
	// List of unknown type
	public static void displayResults(List<?> list){
		System.out.println(list);
	}
}
