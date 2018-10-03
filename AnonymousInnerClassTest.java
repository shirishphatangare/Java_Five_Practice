
/* Any anonymous inner class can implement only one interface at one time. 
 * It can either extend a class or implement interface at a time.
 */

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		// Below Anonymous Inner class is subclass of Superclass
		new Superclass() {
			public void show(){
				super.show();
				System.out.println("Inside AnonymousInnerClass which is subclass of Superclass..");
			}
		}.show();
		
		// Access instance of Anonymous Inner class that implements Showable interface
		interShow.show();
	}
	
	// Below Anonymous Inner class implements Showable interface
	static Showable interShow = new Showable() {
		public void show(){
			System.out.println();
			System.out.println("Inside AnonymousInnerClass which implements the interface Showable..");
		}
	};

}


class Superclass{
	public void show(){
		System.out.println("Inside Superclass..");
	}
}

interface Showable {
	public void show();
}
