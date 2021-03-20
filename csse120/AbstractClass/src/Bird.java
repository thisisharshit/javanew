
public class Bird extends Animal implements Canfly{

	public Bird(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(getName()+" is pecking");
		
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("breathe in, breathe out, repeat");
		
	}

	public void fly() {
		System.out.println(getName()+" is flapping its wings");
		
	}
	
	
	
}
