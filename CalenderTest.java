import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;


public class CalenderTest {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String month = in.next();
	    String day = in.next();
	    String year = in.next();
	    
	    System.out.println(getDay(day, month, year));
	    in.close();
	}
	
	public static String getDay(String day, String month, String year){
	   Calendar calendar = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
	    
	   return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
	    
	}

}



