
/* Local inner class cannot access non-final local variable till JDK 1.7. Since JDK 1.8, 
 * it is possible to access the non-final local variable in method local inner class. 
 */

public class MethodLocalInnerClassTest {

	public static void main(String[] args) {
		MethodLocalInnerClassTest n = new MethodLocalInnerClassTest();
		n.outerMetod();
	}
	
	public void outerMetod(){
		System.out.println("inside outerMethod"); 
        // Inner class is local to outerMethod() 
		class MethodLocalClass{
			public void displayMessage(){
				System.out.println("Inside displayMessage method of MethodLocalClass which is inside outerMethod");
			}
		}
		
		MethodLocalClass localClass = new MethodLocalClass();
		localClass.displayMessage();
	}

}