import java.util.Scanner;

public class StringSortTest {

	public static String getSmallestAndLargest(String s, int k) {
        String[] tokens = new String[(s.length()-k)+1];
        
        for(int i=0;i<s.length()-2;i++){
        	String sub = s.substring(i,i+3);
        	tokens[i] = sub;
        }
        
        
        for(int i=0;i<tokens.length;i++) {
        	for(int j=i+1;j<tokens.length;j++) {
        		if(tokens[i].compareTo(tokens[j]) > 0) {
        			String a = tokens[i];
        			tokens[i] = tokens[j];
        			tokens[j] = a; 
        		}
        	}
        }
        
        return tokens[0] + "\n" + tokens[tokens.length-1];
    }
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        
        System.out.println(getSmallestAndLargest(s, k));
    }
}
