import java.util.Scanner;

public class ScannerTest2 {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String lines = System.lineSeparator();
	        System.out.println(lines);
	        int i = scan.nextInt();
	        double d = scan.nextDouble();
	        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        //scan.skip(lines);
	        String s = scan.nextLine();

	        System.out.println("String: " + s);
	        System.out.println("Double: " + d);
	        System.out.println("Int: " + i);
	    }
}
