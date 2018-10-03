import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSolution {

	public static void main(String[] args) {
			Buddy A = new Buddy("A");
			Buddy B = new Buddy("B");
			
			Thrd1 t1 = new Thrd1(A,B);
			Thrd2 t2 = new Thrd2(A,B);
			
			t1.setName("Thread1");
			t2.setName("Thread2");
			
			t1.start();
			t2.start();
	}

}


class Buddy {
	String name;
	
	/* The traditional way to achieve thread synchronization in Java is by the use of synchronized 
	 * keyword. While it provides a certain basic synchronization, the synchronized keyword is quite 
	 * rigid in its use. For example, a thread can take a lock only once. Synchronized blocks don’t 
	 * offer any mechanism of a waiting queue and after the exit of one thread, any thread can take 
	 * the lock. This could lead to starvation of resources for some other thread for a very long period 
	 * of time.
	 * Reentrant Locks are provided in Java to provide synchronization with greater flexibility.
	 */
	
	
	
	Lock lock = new ReentrantLock();
	
	public Buddy(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}
	
	
	public Lock getLock() {
		return lock;
	}


	public boolean checkBowability(Buddy bower) {
		boolean myLock = false;
		boolean yourLock = false;
		
		try {
			myLock = getLock().tryLock();
			yourLock = bower.getLock().tryLock();
		}finally {
			if(!(myLock && yourLock)) {
				if(myLock) {
					getLock().unlock();
				}
				
				if(yourLock) {
					bower.getLock().unlock();
				}
				
			}
		}
	
		return myLock && yourLock;
	}
	
	
	public void bow(Buddy buddy) {
		if(checkBowability(buddy)) {
			try {
				System.out.println(this.getName() + " bowed to " + buddy.getName());
				buddy.bowBack(this);
				System.out.println(buddy.getName() + " bow back Done to " + this.getName());
				System.out.println();
			}finally{
				getLock().unlock();
				buddy.getLock().unlock();
				
			}
		}else {
			System.out.format("%s started"
                    + " to bow to %s, but saw that"
                    + " %s was already bowing to"
                    + " him.%n",
                    this.name, buddy.getName(), buddy.getName());
            }
		}
	
	public void bowBack(Buddy buddy) {
		System.out.println(this.getName() + " bowing back to " + buddy.getName());
	}
	
}


class Thrd1 extends Thread {
	Buddy A,B;
	
	public Thrd1(Buddy a, Buddy b) {
		super();
		A = a;
		B = b;
	}


	public void run() {
		Random random = new Random();
        for (;;) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
            A.bow(B);
        }
	}
} 


class Thrd2 extends Thread {
	Buddy A,B;
	
	public Thrd2(Buddy a, Buddy b) {
		super();
		A = a;
		B = b;
	}
	public void run() {
		Random random = new Random();
        for (;;) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
            B.bow(A);
        }

	}
	
} 
