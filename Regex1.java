import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Regex1 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		while(testCases > 0) {
			boolean isPatternValid = true;
			String pattern = in.nextLine();
          	
			try {
				Pattern.compile(pattern);
			}catch(PatternSyntaxException e) {
				isPatternValid = false;
			}finally {
				if(isPatternValid) {
					System.out.println("Valid");
				}else {
					System.out.println("Invalid");
				}
				testCases--;
			}
		}
		
		in.close();
	}

}
