
public class GenericsClassTest {

	public static void main(String[] args) {
		Integer index = 12;
		Animal cat = new Cat();
		Test<Integer,Animal> test1 = new Test<Integer,Animal>(index,cat);
		test1.printSound();
		
		String name = "Tommy";
		Dog dog = new Dog();
		Test<String,Dog> test2 = new Test<String,Dog>(name,dog);
		test2.printSound();
	}

}


class Test<T1, T2 extends Animal>{
	
	T1 obj;
	T2 species;
	
	public Test(T1 obj,T2 species) {
		this.obj = obj;
		this.species = species;
	}
	
	public void printSound() {
		System.out.print(obj + "likes -");
		species.speak();
	}

}


class Animal {
	
	public void speak() {
		System.out.println("General sound!!");
	}
	
}

class Cat extends Animal{
	
	public void speak() {
		System.out.println("Miaw Miaw!!");
	}
}


class Dog extends Animal{
	
	public void speak() {
		System.out.println("Bhow Bhow!!");
	}
}