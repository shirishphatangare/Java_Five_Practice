import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* Differences between Collections.SynchronizedMap and ConcurrentHashMap */ 

public class SynchronizedMapVsConcurrentHashMap {

	public static void main(String[] args) {
		//Map<String,String> hashMap = new HashMap<String,String>();
		// Returns a synchronized (thread-safe) map backed by the hashMap object
		//Map<String,String> syncHashMap = Collections.synchronizedMap(hashMap);
		
		ConcurrentHashMap<String,String> conHashMap = new ConcurrentHashMap<String,String>();
		
		new MyThread1(conHashMap);
		new MyThread2(conHashMap);
		new MyThread3(conHashMap); // Till this step no sync issues between Threads accessing syncHashMap
		
		// It is imperative that the user manually synchronize on the returned map when iterating over any of its collection views,
		// Otherwise ConcurrentModificationException will be thrown
		//synchronized (syncHashMap) { // prevents ConcurrentModificationException for synchronizedMap. Not Required for ConcurrentHashMap
			for(Entry<String,String> e:  conHashMap.entrySet()) {
				System.out.println("key: " + e.getKey() + " value: " + e.getValue());
			}
		//}
		
/* Sample alternative iteration code which prevents ConcurrentModificationException for synchronizedMap*/
		
//	  Map m = Collections.synchronizedMap(new HashMap());
//	  Set s = m.keySet();  // Needn't be in synchronized block
//	  synchronized (m) {  // Synchronizing on m, not s!
//	      Iterator i = s.iterator(); // Must be in synchronized block
//	      while (i.hasNext())
//	          foo(i.next());
//	  }
		
	}
}

class MyThread1 implements Runnable {
	Map<String,String> map;
	
	public MyThread1(Map<String,String> map) {
		this.map = map;
		new Thread(this,"MyThread1").start();
	}
	
	public void run() {
		map.put("One", "1");
		try {
			System.out.println(Thread.currentThread().getName() + " Sleeping..");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread2 implements Runnable{
	Map<String,String> map;
	
	public MyThread2(Map<String,String> map) {
		this.map = map;
		new Thread(this,"MyThread2").start();
	}
	
	public void run() {
		map.put("Two", "2");
		try {
			System.out.println(Thread.currentThread().getName() + " Sleeping..");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread3 implements Runnable{
	Map<String,String> map;
	
	public MyThread3(Map<String,String> map) {
		this.map = map;
		new Thread(this,"MyThread3").start();
	}
	
	public void run() {
		map.put("Three", "3");
		try {
			System.out.println(Thread.currentThread().getName() + " Sleeping..");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
