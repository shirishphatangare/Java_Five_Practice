
public class ThreadSyncTest {
	char c ;
	boolean wait = true;

	public static void main(String[] args) {
		final ThreadSyncTest test = new ThreadSyncTest();
		
		Thread t1 = new Thread() {
			public void run() {
				for( test.c='a';test.c<='z';test.c++) {
					test.displayChatMessage1();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		Thread t2 = new Thread() {
			public void run() {
				while(test.c >='a' && test.c <= 'z') {
					test.displayChatMessage2();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t1.start();
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		t2.start();
	}
	
	public synchronized void displayChatMessage1() { // Without synchronized some updates to char c  will be missed
			try {
				
				/* Threads often have to coordinate their actions. The most common coordination idiom is the guarded 
				 * block. Such a block begins by polling a condition that must be true before the block can proceed.*/
				
				while(!wait) {
					//wait()-It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().
					wait();
					//wait(2000); - calling thread sleep only for a time specified. Here, 2 secs
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Produced - " + c);
			wait = false;
			notify();
	}
	
	
	public synchronized void displayChatMessage2() { // Without synchronized some updates to char c  will be missed
			try {
				while(wait) {
					//wait()-It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().
					wait();
					//wait(2000); - calling thread sleep only for a time specified. Here, 2 secs
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Consumed - " + c);
			System.out.println();
			
			//notify()-It wakes up one single thread that called wait() on the same object. It should be noted that 
			//calling notify() does not actually give up a lock on a resource.
			//notifies the waiting threads that now they can wake up but only after the current method terminates.
			//For getting the desired result, it is advised to use notify only at the end of your method.
			wait = true;
			notify();
	}

}