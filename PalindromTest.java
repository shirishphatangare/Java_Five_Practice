import java.util.Scanner;

public class PalindromTest {

	public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        char[] pal1 = A.toCharArray();
        String pal2 = "";
        
        
        for(int i=pal1.length-1;i>=0;i--) {
        	pal2 = pal2 + pal1[i];
        }
        
        
        if(A.equals(pal2)) {
        	System.out.println("Yes");
        }
        else {
        	System.out.println("No");
        }

        
    }

}
