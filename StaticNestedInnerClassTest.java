
class StaticNestedInnerClassTest {
	private static int x = 100;
	
	public static void main(String[] args) {
		StaticNestedInnerClass.displayMessage();
		OuterClass1.InnerClass.displayMessage();
	}
	
	
	//Like any other instance variable, we can have access modifier private, protected, public and default modifier.
	private static class StaticNestedInnerClass{
		public static void displayMessage(){
			// Nested Inner class can access any private static instance variable of outer class.
			System.out.println("Value of x is - " + x);
		}
	}
}


class OuterClass1 {
	static class InnerClass {
		/* We can have static method in a static nested inner class */
		public static void displayMessage() {
			System.out.println("Inside static nested Class of outer Class...");
		}
	}
}
