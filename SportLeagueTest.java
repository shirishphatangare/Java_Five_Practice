import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SportLeagueTest {

	public static void main(String[] args) {
		League<CricketTeam> ipl= new League<CricketTeam>("Indian Premier League");
		
		CricketTeam c1 = new CricketTeam("Hyderabad Sunrisers");
		CricketTeam c2 = new CricketTeam("Rajastan Royals");
		CricketTeam c3 = new CricketTeam("Mumbai Indians");
		CricketTeam c4 = new CricketTeam("Delhi Daredevils");
		
		//FootballTeam f1 = new FootballTeam("Manchester United");
		//ipl.addToTeam(f1); // Compilations fails due to incompatible types
		
		ipl.addToTeams(c1);
		ipl.addToTeams(c2);
		ipl.addToTeams(c3);
		ipl.addToTeams(c4);
		
		c1.setPoints(45);
		c2.setPoints(15);
		c3.setPoints(35);
		c4.setPoints(19);
		
		ipl.displayTeams();
	}

}

class League<T extends Team> {
	String name;
	List<T> listOfTeams = new ArrayList<T>();
	
	public League(String name){
		this.name=name;
	}
	
	public boolean addToTeams(T team){
		if(listOfTeams.contains(team)){
			return false;
		}else{
			listOfTeams.add(team);
			return true;
		}
	}
	
	public void displayTeams(){
		
		System.out.println("League Table for " + this.name);
		Collections.sort(listOfTeams);
		
		for(T team: listOfTeams){
			System.out.println(team.getName() + " : " + team.getPoints());
		}
		
	}
	
}


class Team implements Comparable<Team>{
	
	String name;
	int points;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int compareTo(Team t) {
		if(this.points < t.points){
			return 1;
		}else if(this.points > t.points){
			return -1;
		}else{
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Team [name=" + name + ", points=" + points + "]";
	}
	
}

class CricketTeam extends Team {
	public CricketTeam(String name){
		this.name = name;
		this.points = 0;
	}
}

class FootballTeam extends Team {
	public FootballTeam(String name){
		this.name = name;
		this.points = 0;
	}
}

