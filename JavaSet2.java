import java.util.HashSet;
import java.util.Scanner;

public class JavaSet2 {

	public static void main(String[] args) {
		HashSet<String> nameSet = new HashSet<String>();
		int numberUniquePairs = 0;
		
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        String [] pair = new String[2];
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair = s.nextLine().split(" ");
            pair_left[i] = pair[0];
            pair_right[i] = pair[1];
        }
        
        for (int i = 0; i < t; i++) {
        	String concatenataedName = pair_left[i] + " " + pair_right[i];
            if(nameSet.add(concatenataedName)){
            	numberUniquePairs++;
            }
            System.out.println(numberUniquePairs);
        }
        
        s.close();
	}
}
