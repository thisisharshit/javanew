
public class main {
	public static void main(String[] args) {
		Dog dog=new Dog("bruno");
		dog.breathe();
		dog.eat();
		
		/*Bird bird = new Bird("parrot");
		bird.breathe();bird.eat();
		*/
		
		Parrot parrot=new Parrot("australian ringneck");
		parrot.breathe();
		parrot.eat();
		parrot.fly();
		Penguin penguin=new Penguin("emperor");
		penguin.fly();
	
		
	}
}
