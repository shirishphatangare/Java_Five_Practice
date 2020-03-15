class A1 {
	
	static int i = 100;
	int j = 200;
	
	// static block
	static {
		System.out.println("First static block i before operation " + i); // i = 100
		
		i = i-- - --i; // i = 100 - 98 = 2
		
		System.out.println("First static block i after operation " + i); // i = 2
	}
	
    // Normal block
	{
		System.out.println("Second normal block i before operation " + i); // i = 0
		System.out.println("Second normal block j before operation " + j); // j = 200
		
		i = i++ + ++i; // i = 0 + 2 = 2 
		j = j++ + ++j;  // j = 200 + 202 = 402
		
		System.out.println("Second normal block i after operation " + i); // i = 2
		System.out.println("Second normal block j after operation " + j); // j = 402
	}
	
}

class B1 extends A1 {
	
	// static block
	static {
		System.out.println("Third static block i before operation " + i); // i = 2
		
		i = --i - i--; // i = 1 - 1 = 0
		
		System.out.println("Third static block i after operation " + i); // i = 0
	}
	
    // Normal block
	{
		System.out.println("Forth normal block i before operation " + i); // i = 2
		System.out.println("Forth normal block j before operation " + j); // j = 402
		
		i = ++i + i++; // i = 3 + 3 = 6
		j = ++j + j++; // j = 403 + 403 = 806
		
		System.out.println("Forth normal block i after operation " + i); // i = 6
		System.out.println("Forth normal block j after operation " + j); // j = 806
	}
	
}


public class StaticBlockInheritance {

	public static void main(String[] args) {
		B1 b = new B1();
		
		System.out.println("Value of b.i " + b.i);
		System.out.println("Value of b.j " + b.j);
	}

}
