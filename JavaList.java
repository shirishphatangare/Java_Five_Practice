import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int [] list = new int[n];
		
		for(int i=0; i<n; i++) {
			list[i] = scanner.nextInt();
		}
		
		int q = scanner.nextInt();
		int [] queryInsertParams = new int[2];
		int deleteIndex = -1;
		List<Integer> outputList = new ArrayList<Integer>();
		
		for(int num: list) {
			outputList.add(num);
		}
		
		for(int i=0; i<q; i++) {
			String query = scanner.next();
			
			if(query.equals("Insert")) {
				queryInsertParams[0] = scanner.nextInt();
				queryInsertParams[1] = scanner.nextInt();
				
				// Insert operation
				int insertIndex = queryInsertParams[0];
				int insertInteger = queryInsertParams[1];
				
				outputList.add(insertIndex, insertInteger);

			}else {
				deleteIndex = scanner.nextInt();
				
				// Delete Operation
				outputList.remove(deleteIndex);
			}
		}
		
		
		//Print outputList
		for(Integer num: outputList) {
				System.out.print(num);
				System.out.print(" ");
		}
		
	}

}
