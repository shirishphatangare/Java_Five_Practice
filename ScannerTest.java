import java.util.Scanner;

public class ScannerTest {
	
	private Scanner scanner;

	public ScannerTest(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public static void main(String[] args) {
		String inputChoice = null;
		Scanner scanner = new Scanner(System.in);
		
		ScannerTest scannerTest = new ScannerTest(scanner);
		
		if(args.length > 0) {
			inputChoice = args[0];
			
			if(inputChoice.equals("INDIVIDUAL")) {
				scannerTest.ScannerByIndividualChoice();
			}else if(inputChoice.equals("LINEBYLINE")){
				scannerTest.ScannerLineByLineChoice();
			}else {
				scannerTest.showUsage();
			}
		}else {
			scannerTest.ScannerByIndividualChoice();
		}
	}
	
	private void showUsage() {
		System.out.println("Usage: ScannerTest <arg>");
		System.out.println("For individual inputs: ScannerTest INDIVIDUAL");
		System.out.println("For Line inputs: ScannerTest LINEBYLINE");
	}
	
	private void ScannerByIndividualChoice(){
		String line = null;
		
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		
		while(line == null) {
			line = scanner.nextLine();
			String input[] = line.split(" ");
			
			try {
				twenties = Integer.parseInt(input[0]);
				tens = Integer.parseInt(input[1]);
				fives = Integer.parseInt(input[2]);
				ones = Integer.parseInt(input[3]);
				break;
			}catch(NumberFormatException e) {
				System.out.println("Expecting an Integer. You entered " + line);
				line=null;
			}
		}
		
		int sum =  twenties + tens + fives + ones;
		
		System.out.println("Total amount is - $" + sum);
	}
	
	
	private void ScannerLineByLineChoice(){
		System.out.println("Yet to implement...");
	}

}
