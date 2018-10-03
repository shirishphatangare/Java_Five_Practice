
/*Starvation describes a situation where a thread is unable to gain regular access to shared resources and is unable to make progress. 
This happens when shared resources are made unavailable for long periods by "greedy" threads. 
For example, suppose an object provides a synchronized method that often takes a long time to return. 
If one thread invokes this method frequently, other threads that also need frequent synchronized access to the same object will often be blocked.*/


public class StarvationProblemTest {

	public static void main(String[] args) {
		final CommonClass cc = new CommonClass();
		
		Thread greedyThread = new Thread() {
			public void run() {
				for(int i=0;i<100;i++) {
					cc.longDurationMethod();
					/*try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		};
		
		
		Thread starvedThread = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<100;i++) {
					cc.shortDurationMethod();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
/* 	Here starvedThread is starved due to minimum priority and invoking short duration method on monitor cc
 *  Whereas greedyThread is enjoying access to monitor cc due to maximum priority and invoking long duration method on monitor cc
 */  
		starvedThread.setPriority(Thread.MIN_PRIORITY);
		starvedThread.setName("STARVED THREAD");
		starvedThread.start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		greedyThread.setPriority(Thread.MAX_PRIORITY);
		greedyThread.setName("GREEDY THREAD");
		greedyThread.start();
			
	}

}



class CommonClass {
	
	public synchronized void longDurationMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + " accessing longDurationMethod");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized void shortDurationMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + " accessing shortDurationMethod");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


