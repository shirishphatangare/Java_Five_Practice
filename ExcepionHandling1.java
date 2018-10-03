import java.util.InputMismatchException;
import java.util.Scanner;


public class ExcepionHandling1 {

	public static void main(String[] args) {
			/*boolean isInputMismatchException = false;
			InputMismatchException e1 = null;
			int[] x = new int [2];
			Scanner scanner = new Scanner(System.in);
			for(int i=0; i<2; i++){
				try {
					x[i] = scanner.nextInt();
				} catch(InputMismatchException e){
					isInputMismatchException = true;
					e1 = e;
					scanner = new Scanner(System.in);
				}
			}
			
			if(isInputMismatchException){
				System.out.println(e1.getClass().getName());
				System.exit(1);
			}else{
				try {
					System.out.println(x[0]/x[1]);
				}catch(Exception e2){
					System.out.println(e2.toString());
				}
			}
			scanner.close();*/
		
		
		Scanner scanner = new Scanner(System.in);
		 try {
			    System.out.println(scanner.nextInt()/scanner.nextInt());
			} catch (ArithmeticException aex) {
			    System.out.println(aex);
			} catch (InputMismatchException imex) {
			    System.out.println(imex.getClass().getName());
			}
		 scanner.close();
	}
}
