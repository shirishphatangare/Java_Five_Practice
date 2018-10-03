import java.util.Scanner;


public class OneDimArray {
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scan.nextInt();
		
		int[] input = new int[n];
		
		for(int i=0;i<n;i++){
			input[i] = scan.nextInt();
		}
		
		System.out.println("Input Array is - ");
		
		for(int i=0;i<n;i++){
			System.out.println(input[i]);
		}
		
		scan.close();
	}
	
}
