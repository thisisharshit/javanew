import java.util.ArrayList;

import com.sun.source.tree.Scope;



public class Main {
	public static void main(String[] args) {
		FootballPlayer joe=new FootballPlayer("joe");
		BaseballPlayer pat=new BaseballPlayer("pat");
		SoccerPlayer beckham=new SoccerPlayer("beckham");
		
		Team<FootballPlayer> one=new Team<>("one");
		one.addplayer(joe);
		//one.addplayer(pat);
		//one.addplayer(beckham);
		System.out.println(one.numplayers());
		Team<BaseballPlayer> two=new Team<>("two");
		two.addplayer(pat);
		System.out.println();
		
		
		/*Team<String> brokenteam=new Team<String>("brokenteam");
		brokenteam.addplayer("null");
		*/
		
		Team<SoccerPlayer> brokenTeam=new Team<SoccerPlayer>("this wont work");
		brokenTeam.addplayer(beckham);
		
		Team<FootballPlayer> melbourne=new Team<FootballPlayer>("Melbourne");
		FootballPlayer banks=new FootballPlayer("Gordon");
		melbourne.addplayer(banks);
		
		Team<FootballPlayer> hawthorn=new Team<FootballPlayer>("Hawthorn");
		Team<FootballPlayer> freemantle=new Team<FootballPlayer>("Freemantle");
		
		hawthorn.matchresult(freemantle, 1, 0);
		hawthorn.matchresult(one, 3,8);
		
		one.matchresult(freemantle, 2, 1);
		//one.matchresult(two,1,1);
		
		/*one.ranking();
		two.ranking();
		freemantle.ranking();
		hawthorn.ranking();
		melbourne.ranking();
		*/
		System.out.println(one.compareTo(melbourne));
		System.out.println(one.compareTo(hawthorn));
		System.out.println(melbourne.compareTo(freemantle));
		
		
	}
	
}
