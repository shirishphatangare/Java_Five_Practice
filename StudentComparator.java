import java.util.*;

class Studen {
	private int id;
	private String fname;
	private double cgpa;
	
	
	public Studen(int id, String fname, double cgpa) {
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
		return "Studen [id=" + id + ", fname=" + fname + ", cgpa=" + cgpa
				+ "]";
	}
	
	
}

//Complete the code
public class StudentComparator
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Studen> StudenList = new ArrayList<Studen>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Studen st = new Studen(id, fname, cgpa);
			StudenList.add(st);
			
			testCases--;
		}
        
        SortChecker1 sortChecker1 = new SortChecker1();
        SortChecker2 sortChecker2 = new SortChecker2();
        
        Collections.sort(StudenList,sortChecker1);
        Collections.sort(StudenList,sortChecker2);
      
      	for(Studen st: StudenList){
			System.out.println(st.getFname());
		}
      	in.close();
	}
}

class SortChecker1 implements Comparator<Studen>{

    public int compare(Studen s1, Studen s2) {
        if(s1.getCgpa() < s2.getCgpa()){
            return 1;
        }else if(s1.getCgpa() > s2.getCgpa()){
            return -1;
        }else{
            return s1.getFname().compareTo(s2.getFname());
        }
    }
    
}


class SortChecker2 implements Comparator<Studen>{

    public int compare(Studen s1, Studen s2) {
        if(s1.getFname().equals(s2.getFname())){
            if(s1.getId() > s2.getId()){
                return 1;
            }else if(s1.getId() < s2.getId()){
                return -1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
    


