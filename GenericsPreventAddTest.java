import java.util.ArrayList;
import java.util.List;


public class GenericsPreventAddTest {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();// If you declare a method to take ArrayList<Animal>, it can ONLY take an ArrayList<Animal>, not ArrayList<Dog> or ArrayList<Cat>
		//List<Animal> animals = new ArrayList<Dog>(); // Similarly this declaration is not allowed
		// Above declaration or method calls are allowed for Arrays but not collections. Because Array types are checked again at runtime, but collection type checks happen only at compile-time
		List<? extends Animal> animals1 = new ArrayList<Animal>();
		List<? extends Animal> dogs = new ArrayList<Dog>();
		
		// add operation not allowed for Type List<? extends Animal> . - It is not possible to add elements in collection that uses ? extends.
		// However if we change Type to List<Animal> list=new ArrayList<Animal>(), add operation is allowed 
		
		/*animals.add(new Animal());
		animals1.add(new Dog());
		dogs.add(new Dog());*/
		
		processList(animals1);
		// List<? extends Animal> can not be passed to method with parameter ArrayList<? extends Animal>. It has to match
	}
	
	
	/* 
	 * public <T extends Animal> void method(ArrayList<T> list) is SAME as below 
	 * public void method(List<? extends Animal> list)
	 * 
	 * First syntax is preferred in scenario below - 
	 * public <T extends Animal> void method(ArrayList<T> list1,ArrayList<T> list2) instead of typing
	 * public void method(List<? extends Animal> list1,List<? extends Animal> list2)
	 */
	
	
	public static void processList(List<? extends Animal> list){
		
		System.out.println(list);
		//list.add(new Animal()); // add operation not allowed for ArrayList<? extends Animal> parameter. 
								  // However if we change parameter to ArrayList<Animal> list, add operation is allowed 
	}

}


class Animal{
	
	
}

class Dog extends Animal{}
