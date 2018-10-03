
public class PassByValuePrimitiveTest {

	int x = 100;
	int y = 200;
	
	public static void main(String[] args) {
		int z = 500;
		int p = 600;
		
		PassByValuePrimitiveTest test = new PassByValuePrimitiveTest();
		
		System.out.println("In Main method.. Primitives: " + z + " " + p );
		System.out.println("In Main method.. Object reference: " + test.getX() + " " + test.getY());
		
		test.display(z,p,test);
		// primitives are NOT changed after method call
		System.out.println("Back to Main method..  Primitives: " + z + " " + p);
		
		// Values of object are changed after method call
		System.out.println("Back to Main method..  Object reference: " + test.getX() + " " + test.getY());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	// Java is ALWAYS pass by value - Primitives AS WELL AS Object references BOTH
	// For Object reference, actual object is not passed BY COPY to method. However, a reference is passed BY COPY.
	// that means reference copy and original reference both point to same object on heap and hence any changes made to object using reference copy is also retained after method call.
	// For Primitive, it is passed by copy. A new copy is made in memory for primitive parameter. Hence, any changes made on parameter inside method is not reflected to original primitive after method call
	
	public void display(int parameter1,int parameter2,PassByValuePrimitiveTest reference1){
		System.out.println("Entering display method.. Primitives: " + parameter1 + " " + parameter2 );
		System.out.println("Entering display method.. Object reference: " + reference1.getX() + " " + reference1.getY());
		
		parameter1++;
		parameter2++;
		
		reference1.setX(1000);
		reference1.setY(2000);
		
		System.out.println("Leaving display method.. Primitives: " + parameter1 + " " + parameter2);
		System.out.println("Leaving display method.. Object reference: " + reference1.getX() + " " + reference1.getY());
	}

}

