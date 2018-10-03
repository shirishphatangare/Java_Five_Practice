import java.util.Scanner;

public class Regex2 {

	 public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()){
	            String IP = in.next();
	            System.out.println(IP.matches(new MyRegex().pattern));
	        }
	        
	        in.close();

	  }

}

class MyRegex{
	final String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d{1}|25[0-5]{1})";
	final String pattern = "((" + zeroTo255 + "[.]){3}" +  zeroTo255 + ")";   
}
