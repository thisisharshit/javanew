package HelloWorld;

public class encapsulation {

	public static void main(String  args[]) {
		player player1 = new player();
		player1.name="tim";
		player1.health=20;
		player1.weapon = "sword"; 
		int d=10;
		player1.losehealth(d);
		System.out.println("remaining health = "+player1.healthremaining());
		d=10;
		player1.losehealth(d);
		System.out.println("remaining health = "+player1.healthremaining());
	}
		

}
class player{
	public String name,weapon;//this is not encapsulation and a bad ppractice to use fields directly
	public int health;
	public void losehealth(int damage) {
		this.health-=damage;
		if(this.health<=0) {
			System.out.println("player out");
		}
	}
	public int healthremaining() {
		return this.health; 
	}
}
