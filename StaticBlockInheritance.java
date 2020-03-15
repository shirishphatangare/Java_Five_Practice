class A1 {
	
	static int i = 100;
	int j = 200;
	
	// static block
	static {
		System.out.println("First static block i before operation " + i);
		
		i = i-- - --i; // i = 100 - 98 = 2
		
		System.out.println("First static block i after operation " + i);
	}
	
    // Normal block
	{
		System.out.println("Second normal block i before operation " + i);
		System.out.println("Second normal block j before operation " + j);
		
		i = i++ + ++i; // i = 0 + 2 = 2 
		j = j++ + ++j;  // j = 200 + 202 = 402
		
		System.out.println("Second normal block i after operation " + i);
		System.out.println("Second normal block j after operation " + j);
	}
	
}

class B1 extends A1 {
	
	// static block
	static {
		System.out.println("Third static block i before operation " + i);
		
		i = --i - i--; // i = 1 - 1 = 0
		
		System.out.println("Third static block i after operation " + i);
	}
	
    // Normal block
	{
		System.out.println("Forth normal block i before operation " + i);
		System.out.println("Forth normal block j before operation " + j);
		
		i = ++i + i++; // i = 3 + 3 = 6
		j = ++j + j++; // j = 403 + 403 = 806
		
		System.out.println("Forth normal block i after operation " + i);
		System.out.println("Forth normal block j after operation " + j);
	}
	
}


public class StaticBlockInheritance {

	public static void main(String[] args) {
		B1 b = new B1();
		
		System.out.println("Value of b.i " + b.i);
		System.out.println("Value of b.j " + b.j);
	}

}
