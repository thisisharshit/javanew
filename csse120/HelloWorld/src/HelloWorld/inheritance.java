package HelloWorld;



public class inheritance {
	public static void main(String args[]) {
		animal animal = new animal("animal", 1, 1, 5,5);
		dog dog = new dog("yorkie", 8, 20, 2, 4, 1, 20, "silky");
		dog.move(3);
		animal animal1 = new dog(null, 0, 0, 0, 0, 0, 0, null);
		animal.move(10);
		animal1.move(10);
		//fish fish  = new fish(name, size, weight, gills, eyes, fins)
	}
}

class animal{
	private String name;
	private int brain,body,size,weight;
	public animal(String name, int brain, int body, int size, int weight) {
		this.name = name;
		this.brain = brain;
		this.body = body;
		this.size = size;
		this.weight = weight;
		
	}
	public void eat() {
		
	}
	public void move(int speed) {
		System.out.println("animal.move() called. animal moving at "+speed);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrain() {
		return brain;
	}
	public void setBrain(int brain) {
		this.brain = brain;
	}
	public int getBody() {
		return body;
	}
	public void setBody(int body) {
		this.body = body;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
class dog extends animal{

	private int eyes,legs,tail,teeth;
	private String coat;
	public dog(String name, int size, int weight
			,int eyes, int legs, int tail, int teeth, String coat) {
		super(name, 1, 1, size, weight);
		this.eyes=eyes;
		this.legs=legs;
		this.coat=coat;
		this.tail=tail;
		this.teeth=teeth;
		// TODO Auto-generated constructor stub
	}
	public void move(int speed) {
		System.out.println("dog.move() called");
		super.move(speed);
		
	}
	
}
class fish extends animal{
	private int gills,eyes,fins;

	public fish(String name, int size, int weight, int gills, int eyes, int fins) {
		super(name, 1, 1, size, weight);
		this.gills = gills;
		this.eyes = eyes;
		this.fins = fins;
	}
	private void rest() {
		
	}
	private void swim() {
		movebackfin();
		movemuscles();
		super.move(2);
	}
	private void movemuscles() {
		
	}
	private void movebackfin() {
		
	}
	
}
