import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/* Callable is similar to Runnable, in that it encapsulates a task that is meant to run on another thread, 
whereas a Future is used to store a result obtained from a different thread.

*To create the thread, a Runnable is required. To obtain the result, a Future is required.

The Java library has the concrete type FutureTask, which implements Runnable and Future, combining both functionality conveniently.
A FutureTask can be created by providing its constructor with a Callable. Then the FutureTask object is provided to the constructor 
of Thread to create the Thread object. Thus, indirectly, the thread is created with a Callable. 
For further emphasis, note that there is no way to create the thread directly with a Callable.
*
*/ 

public class FutureCallableTest {

	public static void main(String[] args) throws Exception { // This exception handling for tasks[i].get() method
		// FutureTask is a concrete class that 
	    // implements both Runnable and Future 
		FutureTask[] tasks = new FutureTask[5];
		
		for(int i=0;i<5;i++){
			CallableTest ctest = new CallableTest();
			
			// Create the FutureTask with Callable 
			tasks[i] = new FutureTask<Integer>(ctest);
			
			// As it implements Runnable, create Thread 
		      // with FutureTask 
			Thread t = new Thread(tasks[i]);
			t.start();
		}
		
		for(int i=0;i<5;i++){
			
			// This method blocks till the result is obtained 
		      // The get method can throw checked exceptions 
		      // like when it is interrupted. This is the reason 
		      // for adding the throws clause to main 
			System.out.println(tasks[i].get()); // // As it implements Future, we can call get() 
		}

	}

}

// Task to be executed via Thread written in call method
class CallableTest implements Callable<Integer> {

	public Integer call() throws Exception {
		Integer result = null;
		Random randomGenerator = new Random();
		result = randomGenerator.nextInt(10);
		Thread.sleep(result * 1000);
		return result;
	}
	
}


