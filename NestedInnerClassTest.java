
public class NestedInnerClassTest {
	private int x = 100;

	public static void main(String[] args) {
		NestedInnerClass n = new NestedInnerClassTest().new NestedInnerClass(); // Own class nested inner class
		n.displayMessage();
		
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();  // Other class nested inner class
		inner.displayMessage();
	}
	
	//Like any other instance variable, we can have access modifier private, protected, public and default modifier.
	private class NestedInnerClass {
		public void displayMessage() {
			// Nested Inner class can access any private instance variable of outer class.
			System.out.println("Value of x is - " + x);
		}
	}
}

class OuterClass {
	class InnerClass {
		public void displayMessage() {
			System.out.println("Inside Inner Class of outer Class...");
		}
		
		/* We can’t have static method in a nested inner class because an inner class is implicitly associated with an object 
		of its outer class so it cannot define any static method for itself.*/ 
		
		/*public static void show() { 
			System.out.println("Inside show method...");
		}*/
	}
}


