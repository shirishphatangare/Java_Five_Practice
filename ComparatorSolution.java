import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class ComparatorSolution {
	private static final Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		Player[] players = new Player[n];
		Checker checker = new Checker();
		
		for(int i=0; i<n; i++){
			players[i] = new Player(scanner.next(),scanner.nextInt());
		}
		
		Arrays.sort(players, checker);
		
		for(int i=0; i<n; i++){
			System.out.print(players[i].getName());
			System.out.print(" ");
			System.out.println(players[i].getScore());
		}
		scanner.close();
	}

}

class Player {
	String name;
	int score;
	
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}

class Checker implements Comparator<Player>{

	public int compare(Player p1, Player p2) {
		
		if(p1.getScore() < p2.getScore()){
			return 1;
		}else if(p1.getScore() > p2.getScore()){
			return -1;
		}else{
			//return 0;
			return (p1.getName().compareTo(p2.getName()));
		}
	}
}