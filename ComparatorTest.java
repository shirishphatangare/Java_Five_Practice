import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Circle> circles = new ArrayList<Circle>();
		CircleComparator circleComparator = new CircleComparator();
		circles.add(new Circle(12));
		circles.add(new Circle(22));
		circles.add(new Circle(32));
		circles.add(new Circle(22));
		circles.add(new Circle(42));
		
		System.out.println("-----Sorting Using Comparable-----");
		System.out.println("Circles before sorting..");
		System.out.println(circles);
		Collections.sort(circles);
		System.out.println("Circles after sorting..");
		System.out.println(circles);
		
		
		System.out.println("-----Sorting Using Comparator-----");
		System.out.println("Circles before sorting..");
		System.out.println(circles);
		Collections.sort(circles,circleComparator);
		System.out.println("Circles after sorting..");
		System.out.println(circles);
	}
	
	
	

}




class Circle implements Comparable<Circle>{
	
	int radius;

	
	public Circle(int radius) {
		
		this.radius = radius;
		
	}
	
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}


	
	public int compareTo(Circle o) {
		if(this.radius < o.radius) {
			return 1;
		} else if(this.radius > o.radius) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
}

class CircleComparator implements Comparator<Circle> {

	public int compare(Circle o1, Circle o2) {
		if(o1.radius > o2.radius) {
			return 1;
		}else if(o1.radius < o2.radius) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
