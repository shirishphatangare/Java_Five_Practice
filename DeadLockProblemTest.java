
/*
 *  When DeadLockProblemTest runs, it's extremely likely that both threads will block when they attempt to invoke bowBack. 
 *	Neither block will ever end, because each thread is waiting for the other to exit bow.
*/

public class DeadLockProblemTest {

	public static void main(String[] args) {
			Friend A = new Friend("A");
			Friend B = new Friend("B");
			
			Thread1 t1 = new Thread1(A,B);
			Thread2 t2 = new Thread2(A,B);
			
			t1.setName("Thread1");
			t2.setName("Thread2");
			
			t1.start();
			t2.start();
	}

}


class Friend {
	String name;
	
	public Friend(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public synchronized void bow(Friend friend) {
		System.out.println(this.getName() + " bowed to " + friend.getName());
		friend.bowBack(this);
		System.out.println(friend.getName() + " bow back Done to " + this.getName());
	}
	
	public synchronized void bowBack(Friend friend) {
		System.out.println(this.getName() + " bowing back to " + friend.getName());
	}
	
}


class Thread1 extends Thread {
	Friend A,B;
	
	public Thread1(Friend a, Friend b) {
		super();
		A = a;
		B = b;
	}


	public void run() {
		A.bow(B);
	}
	
} 


class Thread2 extends Thread {
	Friend A,B;
	
	public Thread2(Friend a, Friend b) {
		super();
		A = a;
		B = b;
	}
	public void run() {
		B.bow(A);
	}
	
} 