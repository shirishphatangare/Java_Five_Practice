import java.util.Scanner;


public class ExceptionHandling2 {

	public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

class MyCalculator {
	
	public int power(int n,int p) throws Exception {
		if(n < 0 ||  p < 0){
			throw new NegativeNumberException();
		}
		
		if(n == 0 && p == 0){
			throw new BothZeroException();
		}
		
		int result = 1;
		
		for(int i=0; i<p; i++) {
			result = result * n;
			
		
		}
		return result;
	}
	
}

class NegativeNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return  Exception.class.getName() +  ": n or p should not be negative.";
	}
}

class BothZeroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return  Exception.class.getName() +  ": n and p should not be zero.";
	}
	
}

