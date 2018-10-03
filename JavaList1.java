import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList1 {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		String [] list = null;
		
		for(int i=0; i<n; i++) {
			list[i] = scanner.next("[0-9]");
		}
		
		int q = scanner.nextInt();
		String [] queryInsertParams = null;
		int deleteIndex = -1;

		
		for(int i=0; i<q; i++) {
			String query = scanner.next("[a-zA-Z]");
			
			System.out.println(query);
			
			if(query.equals("Insert")) {
				queryInsertParams = scanner.nextLine().split(" ");
			}else {
				deleteIndex = scanner.nextInt();
			}
		}
		
		/*String query2 = scanner.nextLine();
		
		if(query2.equals("Insert")) {
			queryInsertParams = scanner.nextLine().split(" ");
		}else {
			deleteIndex = scanner.nextInt();
		}*/
		
		List<Integer> outputList = new ArrayList<Integer>();
		
		for(String num: list) {
			outputList.add(Integer.parseInt(num));
		}
		
		// Insert operation
		int insertIndex = Integer.parseInt(queryInsertParams[0]);
		int insertInteger = Integer.parseInt(queryInsertParams[1]);
		
		outputList.add(insertIndex, insertInteger);
		
		// Delete Operation
		outputList.remove(deleteIndex);
		
		//Print outputList
		
		for(Integer num: outputList) {
			outputList.add(num);
		}
		
	}

}
