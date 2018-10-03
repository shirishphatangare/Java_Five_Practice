
public class ThreadStateTest {

	public static void main(String[] args) {
		
		displayThreadState(Thread.currentThread());
		
		Thread t1 = new Thread() {
			public void run() {
				displayThreadState(Thread.currentThread());
				for(int i=0;i<10;i++) {
					try {
						Thread.sleep(2000);
						displayThreadState(Thread.currentThread());
					} catch (InterruptedException e) {
						displayThreadState(Thread.currentThread());
						//e.printStackTrace();
					}
				}
			}
		};
		
		t1.setName("Thread1");
		displayThreadState(t1);
		t1.start();
		displayThreadState(t1);
		
		
		Thread t2 = new Thread( new Runnable() {
			public void run() {
				displayThreadState(Thread.currentThread());
				synchronized(this){
					System.out.println("Inside Sync");
					displayThreadState(Thread.currentThread());
					try {
						this.wait(3000);
						displayThreadState(Thread.currentThread());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t2.setName("Thread2");
		displayThreadState(t2);
		t2.start();
		displayThreadState(t2);
		
		t1.interrupt();
		
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		displayThreadState(Thread.currentThread());
		displayThreadState(t1);
		displayThreadState(t2);
	}
	
	
	public static void displayThreadState(Thread t) {
		System.out.println( t.getName()  + "- " + t.getState());
	}
}
