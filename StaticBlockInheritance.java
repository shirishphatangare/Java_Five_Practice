class A1 {
	
	static int i = 100;
	int j = 200;
	
	// static block
	static {
		System.out.println("First static block i before operation " + i);
		
		i = i-- - --i;
		
		System.out.println("First static block i after operation " + i);
	}
	
    // Normal block
	{
		System.out.println("Second normal block i before operation " + i);
		System.out.println("Second normal block j before operation " + j);
		
		i = i++ + ++i;
		j = j++ + ++j;
		
		System.out.println("Second normal block i after operation " + i);
		System.out.println("Second normal block j after operation " + j);
	}
	
}

class B1 extends A1 {
	
	// static block
	static {
		System.out.println("Third static block i before operation " + i);
		
		i = --i - i--;
		
		System.out.println("Third static block i after operation " + i);
	}
	
    // Normal block
	{
		System.out.println("Forth normal block i before operation " + i);
		System.out.println("Forth normal block j before operation " + j);
		
		i = ++i + i++;
		j = ++j + j++;
		
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
