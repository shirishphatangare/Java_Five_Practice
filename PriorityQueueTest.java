import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("One");
		pq.add("Four");
		pq.add("Nine");
		pq.add("Ten");
		pq.add("Eleven");
		//pq.add(null); // Do not permit null - Throws nullpointerException
		
		System.out.println(pq);
		
		System.out.println(pq.peek()); // Retrieves head but do NOT remove
		System.out.println(pq.poll()); // Retrieves head and removes
		
		System.out.println(pq);

		pq.offer("Gita"); // Same as add - Adds to PQ as per Priority
		pq.remove(); // removes head of PQ
		System.out.println(pq);
	}

}
