import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Circle>circles = new TreeSet<Circle>();
		List<Circle>circleLists = new ArrayList<Circle>();
		
		circleLists.add(new Circle(1));
		circleLists.add(new Circle(1));
		circleLists.add(new Circle(11));
		circleLists.add(new Circle(11));
		circleLists.add(new Circle(22));
		circleLists.add(new Circle(33));
		circleLists.add(new Circle(44));
		
		circles.addAll(circleLists);
		System.out.println(circles);
		
		circles.add(new Circle(3));
		circles.add(new Circle(32));
		circles.add(new Circle(13));
		circles.add(new Circle(31));
		circles.add(new Circle(33));
		circles.add(new Circle(33));
		circles.add(new Circle(33));

		System.out.println(circles);
		
		System.out.println("Ceiling - " + circles.ceiling(new Circle(5)));
		System.out.println("Floor - " + circles.floor(new Circle(6)));
		System.out.println(circles);
		
		System.out.println("pollFirst" + circles.pollFirst());
		System.out.println("pollLast" + circles.pollLast());
		
		System.out.println(circles);
		
	}

}

class Circle implements Comparable<Circle>{
	
	int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + radius;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		return true;
	}

	public int compareTo(Circle c) {
		if(this.radius < c.radius){
			return 1;
		}else if(this.radius > c.radius){
			return -1;
		}else{
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
	
}
