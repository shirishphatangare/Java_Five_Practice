
public class ThreadExtendTest {

	public static void main(String[] args) {
		
		System.out.println("Inside main thread");
		NewThread newThread = new NewThread();
		newThread.start();
		try{
			newThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Back to main thread");
	}

}


class NewThread extends Thread {
	public void run(){
		System.out.println("Running Run method in Thread..");
	}
}