package HelloWorld;

public class polymorphism {
	public static void main(String args[]) {
		
		for (int i = 1; i < 11; i++) {
			Movie movie = randomMovie();
			System.out.println("Movie #"+i+": "+movie.getName()+"\n"
					+"Plot: "+movie.plot());
		}
		
	}
	public static Movie randomMovie() {
		int randomNumber = (int)(Math.random()*5)+1;
		System.out.println("random no generated was: "+randomNumber);
		switch (randomNumber) {
		case 1:
			return new Jaws();
		case 2:
			return new IndependenceDay();
		case 3:
			return new MazerRunner();
		case 4:
			return new forgetable();
		case 5:
			return new Starwars();
		
		}
		return null;
	}

}
class Movie{
	private String name;

	public Movie(String name) {
		this.name = name;
		System.out.println(name);
	}
	public String plot() {
		return "no plot here";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Jaws extends Movie{
	public Jaws() {
		super("Jaws");
		System.out.println("child class called");
	}
	public String plot() {
		return "a shark eats lots of people";
	}
}
class IndependenceDay extends Movie{

	public IndependenceDay() {
		super("INdependence Day");
		System.out.println("child class called");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String plot() {
		return "aliens attmept to take over the planet";
	}
	
}
class MazerRunner extends Movie{
	public MazerRunner() {
		super("Maze Runner");
		System.out.println("child class called");
	}
	@Override
	public String plot() {
		return "kids try and escape a maze";
	}
}
class Starwars extends Movie{
	public Starwars() {
		super("Starwars");
		System.out.println("child class called");
	}
	@Override
	public String plot() {
		return "Imperial forces try to take over the planet";
		
	}
}
class forgetable extends Movie{
	public forgetable(){
		super("Forgetable");
	}
}