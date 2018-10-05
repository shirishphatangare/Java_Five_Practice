
/* If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.
The distinction between hiding a static method and overriding an instance method has important implications:
1) The version of the overridden instance method that gets invoked is the one in the subclass.
2) The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass. */

public class MethodHidingTest {
	public static void main(String[] args) {
		B instance1 = new B();
		instance1.instanceMethod();
		instance1.classMethod();
		
		A instance2 = new B();
		instance2.instanceMethod();
		instance2.classMethod();
		
		A.classMethod();
		B.classMethod(); // If subclass B DONOT hide(override) a static method in superclass A, then static method from superclass A is called 
	}
}

class A {
	public void instanceMethod(){
		System.out.println("Inside instance method of Class A..");
	}
	
	public static void classMethod(){
		System.out.println("Inside static menthod of Class A..");
	}
}

class B extends A {
	// Method Overriding of non-static method
	public void instanceMethod(){
		System.out.println("Inside instance method of Class B..");
	}
	
	// Method hiding of static method
	public static void classMethod(){
		System.out.println("Inside static method of Class B..");
	}
}