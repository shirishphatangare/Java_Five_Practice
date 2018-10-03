
public class NamesEnum {

	// You can declare enum as its own standalone class, in its own source file or as a member of another class
	enum Names {
		JERRY("Guitar") {public String Sings() {
			return "paintively";	
		}}, 
		BOB("Flute"){ public String Sings() { // constant-specific class bodies
			return "hoarsely";	
		}}, 
		PHILL("Bass");
		// public enum Names { JERRY, BOB, PHILL } // Normal enum declaration without constructor
	
		// enum constructor
		Names(String instrument){
			this.instrument = instrument;
		}
		
		
		private String instrument;

		public String getInstrument() {
			return instrument;
		}

		
		public String Sings() {
			return "occasionally";	
		}
		
	}
	
	
	public static void main(String[] args) {
		
		// Using if and switch with enum
		
		Names name1 = Names.JERRY;
		
		if(name1 == Names.BOB) {
			System.out.println("Inside == match found");
		}
		
		if(name1.equals(Names.JERRY)) {
			System.out.println("Inside equals match found");
		}
		
		Names name2 = Names.PHILL;
		
		switch(name2) {
			case JERRY: System.out.println("JERRY sings"); break;
			case BOB:   System.out.println("BOB sings"); break;
			case PHILL: System.out.println("PHILL sings"); break; 
		}
			
		
		for (Names n: Names.values()) {
			System.out.print(n);
			System.out.print("-----");
			System.out.print(n.getInstrument());
			System.out.print("-----");
			System.out.print(n.Sings());
			System.out.println();
		}
		
	}

	

}
