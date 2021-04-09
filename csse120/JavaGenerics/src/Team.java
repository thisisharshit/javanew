import java.util.ArrayList;



public class Team<T extends Player/*& Coach & Manager*/> implements Comparable<Team<T>>{//player is used to tell java it can only accept type player
	//we can extend from one class and two interfaces at the same time, class first and then interfaces
	//coach and manager are interfaces
	private String name;
	int played=0;
	int won=0;
	int lost=0;
	int tied=0;
	
	private ArrayList<T> members=new ArrayList<T>();
	public Team(String name) {
		super();
		this.name = name;
	}
	public String getname() {
		return name;
	}
	public boolean addplayer(T player) {
		if(members.contains(player)) {
			System.out.println(player.getname()+" is already on this team");
			return false;
		}
		else{
			members.add(player);
			System.out.println( player.getname()+" is picked for the team "+this.name);
			return true;
			
		}
	}
	public int numplayers() {
		return this.members.size();
	}
	
	public void matchresult(Team<T> opponent, int ourscore,int theirscore) {
		String message;
		if(ourscore>theirscore) {won++;message="beat";}
		else if(theirscore>ourscore) {lost++;message="lost to";}
		else {tied++;message="drew with";}
		played++;
		if(opponent!=null) {
			System.out.println(this.getname()+" "+message+" "+opponent.getname());
			opponent.matchresult(null, theirscore, ourscore);
		}
		
	}
	
	public int ranking() {
		return (won*2)+tied;
	}
	@Override
	public int compareTo(Team<T> team) {
		// TODO Auto-generated method stub
		if(this.ranking()>team.ranking()) {
			return -1;
		}
		else if(this.ranking()<team.ranking()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	

}
