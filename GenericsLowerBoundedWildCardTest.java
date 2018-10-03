import java.util.Arrays;
import java.util.List;


public class GenericsLowerBoundedWildCardTest {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,4,23,12,4,2,33);
		displayResults(list1);
		
		List<Number> list2 = Arrays.asList((Number)3,(Number)3.9);
		displayResults(list2);
		
		List<Object> list3 = Arrays.asList((Object)7.3,(Object)2.9,(Object)32);
		displayResults(list3);
	}
	
	public static void displayResults(List<? super Integer> list){
		System.out.println(list);
		
	}

}
