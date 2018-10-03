import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/* Server Programs such as database and web servers repeatedly execute requests from multiple clients and these are oriented around processing a large 
 * number of short tasks. An approach for building a server application would be to create a new thread each time a request arrives and service this new 
 * request in the newly created thread. While this approach seems simple to implement, it has significant disadvantages. A server that creates a new thread 
 * for every request would spend more time and consume more system resources in creating and destroying threads than processing actual requests.

   Since active threads consume system resources, a JVM creating too many threads at the same time can cause the system to run out of memory. 
   This necessitates the need to limit the number of threads being created.

   What is ThreadPool in Java?
   A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. 
   Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive. */


public class ThreadPoolTest {

	public static void main(String[] args) {
		// Maximum number of threads in thread pool
		final int MAX_THREAD_POOL_SIZE = 3;
		
		 // creates five tasks (instances of our Task class)
		Runnable r1 = new Task("Task1");
		Runnable r2 = new Task("Task2");
		Runnable r3 = new Task("Task3");
		Runnable r4 = new Task("Task4");
		Runnable r5 = new Task("Task5");

		// creates a thread pool with MAX_T no. of  
        // threads as the fixed pool size(Step 2) 
		
		/*In case of a fixed thread pool, if all threads are being currently run by the executor 
		 * then the pending tasks are placed in a queue and are executed when a thread becomes idle.
		 */

		ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD_POOL_SIZE);
		
		// passes the Task objects to the pool to execute (Step 3) 
		threadPool.execute(r1);
		threadPool.execute(r2);
		threadPool.execute(r3);
		threadPool.execute(r4);
		threadPool.execute(r5);
		
		 // pool shutdown ( Step 4) 
		threadPool.shutdown();
		
	}

}

class Task implements Runnable {
	
	String name;
	
	public Task(String name) {
		super();
		this.name = name;
	}

	public void run() {
		Date d = new Date();
		SimpleDateFormat s= new SimpleDateFormat("HH:mm:SS");

		
		for(int i=0;i<2;i++) {
			if(i==0) {
				System.out.println("Task - " + name + " is Initiated at " + s.format(d));
				System.out.println();
			}else {
				System.out.println("Task - " + name + " is Executing at " + s.format(d));
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Task - " + name + " is Completed at " + s.format(d));
		System.out.println();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}




