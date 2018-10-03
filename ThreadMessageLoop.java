
public class ThreadMessageLoop {

	public static void main(String[] args) {
		printThreadMessage("Starting MessageLoop Thread");
		double patience = 100;
		
		if(args.length > 0){
			patience = Integer.parseInt(args[0]) * 1000;
		}
		
		Thread t = new Thread(new MessageLoop());
		long starttime = System.currentTimeMillis();
		t.start();
		/*try {
			t.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		while(t.isAlive()){
			//t.interrupt();
			//System.out.println(System.currentTimeMillis() - starttime);
			if(((System.currentTimeMillis() - starttime) > patience) && t.isAlive()){
				printThreadMessage("Tested my patience.. Interrupting Now");
				t.interrupt();
				printThreadMessage("Thread Interrupted.. Won't be long now");
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		printThreadMessage("Finally MessageLoop Terminated..");
	}
	
	private static class MessageLoop implements Runnable {
		String [] messages = {"Live as if you were to die tomorrow. Learn as if you were to live forever.",
							  "To live is the rarest thing in the world. Most people exist, that is all.",
							  "If you tell the truth, you don't have to remember anything.",
							  "You only live once, but if you do it right, once is enough.",
							  "Don't cry because it's over, smile because it happened."};
		public void run() {
			
			int n = (int) (Math.random() * 5);
			//try {
				for(int i=0;i<100000;i++){
					//Thread.sleep(4000);
					n = (int) (Math.random() * 5);
					printThreadMessage(messages[n]);
					if(Thread.interrupted()){
						printThreadMessage("I wasn't done!");
						break;
					}
				}
			//}
			//catch (InterruptedException e) {
			//	printThreadMessage("I wasn't done!");
			//}
		}
	}
	
	static void printThreadMessage(String message){
		System.out.printf("%s - %s\n", Thread.currentThread().getName(), message);
	}

}
