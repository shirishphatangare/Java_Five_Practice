import java.util.Arrays;
import java.util.List;


public class GenericsUpperBoundedWildCardTest {

	public static void main(String[] args) {
			
		List<Integer> intList = Arrays.asList(4,3,5,2,54);
		displayResult(intList);
		
		List<Double> doubleList = Arrays.asList(1.4,3.4,2.4,7.5,5.5);
		displayResult(doubleList);
		
	}
	
	
	// Integer extends java.lang.Number implements java.lang.Comparable
	// Double extends java.lang.Number implements java.lang.Comparable
	public static <T extends Number & Comparable<T>> void displayResult(List<T> list){ 
		System.out.println(list);
	}

}
