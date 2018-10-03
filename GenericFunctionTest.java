
public class GenericFunctionTest {

	public static void main(String[] args) {
		
		Test1 test = new Test1();
		Integer num = 23;
		String str = "Hello";
		Double dbl = 34.45;
		
		test.printMessage(num);
		test.printMessage(str);
		test.printMessage(dbl);

	}

}

class Test1{
	
	// Generic Function
	public<T> void printMessage(T variable) {
		System.out.println(variable.getClass().getName() + "-" + variable );
	}
	
}
