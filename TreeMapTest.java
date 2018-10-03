import java.util.Map.Entry;
import java.util.TreeMap;


public class TreeMapTest {

	public static void main(String[] args) {
		int arr[] = {2,4,3,5,23,45,23,55,66,4,2,2,6,9,23};
		TreeMapTest treeMapTest = new TreeMapTest();
		treeMapTest.printFrequency(arr);
	}
	
	public void printFrequency(int [] arr){
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		
		for(int n: arr){
			Integer c = treeMap.get(n);
			if(c == null){
				treeMap.put(n, 1);
			}else{
				treeMap.put(n, ++c);
			}
		}
		
		for(Entry<Integer,Integer> e: treeMap.entrySet()){
			System.out.println("key - "+ e.getKey() + " value - " + e.getValue());
		}
		
	}
}
