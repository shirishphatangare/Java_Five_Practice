import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/* A PriorityQueue is what is called a binary heap. It is only ordered/sorted in the sense that the first element is the least OR most. 
** In other words, it only cares about what is in the front of the queue, the rest are "ordered" when needed.
** The elements are only ordered as they are dequeued, i.e. removed from the queue using poll(). 
** This is the reason why a PriorityQueue manages to have such good performance, as it is not doing any more sorting than it needs at any time. */

public class StudentPriorityTest {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<String>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getFname());
            }
        }
    }

}


enum EVENT {ENTER,SERVED};

class Priorities{
	
	public List<Student> getStudents(List<String> events){
		QueueSortChecker1 sortChecker1 = new QueueSortChecker1();
		PriorityQueue<Student> studentPriorities = new PriorityQueue<Student>(events.size(),sortChecker1);
		List<Student>outputStudentsList = new ArrayList<Student>();
		
		for(int i=0;i<events.size();i++){
			String [] eventComponenets = events.get(i).split(" ");
			EVENT event = (eventComponenets[0].equals("ENTER"))? EVENT.ENTER : EVENT.SERVED; 
			
			switch(event){
				case ENTER: {studentPriorities.add(new Student(Integer.parseInt(eventComponenets[3]),eventComponenets[1], Double.parseDouble(eventComponenets[2])));   break;}
				case SERVED: {studentPriorities.poll(); break;}
			}
		}
		
		Iterator<Student> remainingStudents = studentPriorities.iterator();
		
		while(remainingStudents.hasNext()){
			outputStudentsList.add(remainingStudents.next());
		}
		// Re-sorting is necessary as PriorityQueue do not sort it completely
		Collections.sort(outputStudentsList, sortChecker1);
		
		return outputStudentsList;
	}
}


class QueueSortChecker1 implements Comparator<Student>{

    public int compare(Student s1, Student s2) {
        if(s1.getCgpa() < s2.getCgpa()){
            return 1;
        }else if(s1.getCgpa() > s2.getCgpa()){
            return -1;
        }else{
        	if(s1.getFname().equals(s2.getFname())){
                if(s1.getId() < s2.getId()){
                    return 1;
                }else if(s1.getId() > s2.getId()){
                    return -1;
                }else{
                    return 0;
                }
            }else{
            	return s1.getFname().compareTo(s2.getFname());
            }
        }
    }
    
}


class Student {
	private int id;
	private String fname;
	private double cgpa;
	
	
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", cgpa=" + cgpa
				+ "]";
	}
	
}
	


