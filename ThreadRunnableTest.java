
public class ThreadRunnableTest {

	public static void main(String[] args) {
		System.out.println("Inside Main Thread");
		
		// Variant 1 - Anonymous Inner class that implements a Runnable interface
		Runnable newRunnable = new Runnable(){
			public void run(){
				System.out.println("Inside Extends thread " + Thread.currentThread().getName());
			}
		};
		Thread t1 = new Thread(newRunnable);
		t1.start();
		
		// Variant 2 - Anonymous Inner class that extends a Thread Class
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("Sleeping inside thread " + Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Woke up inside thread " + Thread.currentThread().getName());
				System.out.println("Inside Runnable thread " + Thread.currentThread().getName());
			}
		};
		t2.start();
		
		// Variant 3 - Anonymous Inner class that defines inside method/constructor argument, here constructor argument 
		Thread t3 = new Thread( new Runnable() {
			public void run() {
				System.out.println("Inside constructor argument thread " + Thread.currentThread().getName());
			}
		});
		t3.start();
		
		try {
			t3.join(); // Causes the current thread (Main Thread) to pause execution until t3 thread terminates
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Back to Main Thread");
	}

}