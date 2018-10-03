
 /* We can use notify() method to give the notification for only one thread which is waiting for a particular object whereas by the help of notifyAll() 
  * methods we can give the notification to all waiting threads of a particular object.
  * 
  * For notify() method, when multiple threads are waiting for same object, Which thread will get the notification we can’t predict 
  * because it totally depends upon the JVM.
  * 
  * We should go for notify(), if all your waiting threads are interchangeable (the order they wake up doesn’t matter). 
  * But we should use notifyAll() for other cases where the waiting threads may have different purposes and should be able to run concurrently.
  */


public class ThreadNotifyAllTest {

	public static void main(String[] args) {
		
		Geek1 g1 = new Geek1();
		Thread t1 = new Thread(g1,"Thread1");
		
		Geek2 g2 = new Geek2(g1);
		Thread t2 = new Thread(g2,"Thread2");

		Geek3 g3 = new Geek3(g1);
		Thread t3 = new Thread(g3,"Thread3");

		t1.start();
		t2.start();
		try {
			// sleep() method keeps lock while sleeping whereas wait() method releases lock while sleeping
			Thread.sleep(1000); // prevents t3 starting and notifying before t1/t2 starts and waits
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
	}
}


class Geek1 implements Runnable{
	public void run() {
		synchronized(this) {
			System.out.println(Thread.currentThread().getName() + "-" + "is waiting");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-" + "is notified");
			//this.notify();
		}
		System.out.println(Thread.currentThread().getName() + "-" + "terminating");
		
	}
}


class Geek2 implements Runnable{
	Geek1 g1;
	
	public Geek2(Geek1 g1) {
		super();
		this.g1 = g1;
	}


	public void run() {
		synchronized(this.g1) {
			System.out.println(Thread.currentThread().getName() + "-" + "is waiting");
			try {
				this.g1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-" + "is notified");
			//this.g1.notify();
		}
		System.out.println(Thread.currentThread().getName() + "-" + "terminating");
		
	}
}


class Geek3 implements Runnable{
Geek1 g1;
	
	public Geek3(Geek1 g1) {
		super();
		this.g1 = g1;
	}


	public void run() {
		synchronized(this.g1) {
			this.g1.notifyAll(); // Instead of using notify() methods above on lines 61 and 35, use notifyAll()
			System.out.println(Thread.currentThread().getName() + "-" + "has notified All threads waiting on monitor g1");
		}
		System.out.println(Thread.currentThread().getName() + "-" + "terminating");
	}
}
