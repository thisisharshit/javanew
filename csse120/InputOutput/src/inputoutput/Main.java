package inputoutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	//private static Map<Integer, Location> locations=new HashMap<Integer, Location>();
	private static Locations locations=new Locations();
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*locations.put(0, new Location(0, "0"));
		locations.put(1, new Location(1, "1"));
		locations.put(2, new Location(2, "2"));
		locations.put(3, new Location(3, "3"));
		locations.put(4, new Location(4, "4"));
		locations.put(5, new Location(5, "5"));
		
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		//locations.get(1).addExit("Q", 0);
		
		locations.get(2).addExit("N", 5);
		//locations.get(2).addExit("Q", 0);
		
		locations.get(3).addExit("W", 1);
		//locations.get(3).addExit("Q", 0);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		//locations.get(4).addExit("Q", 0);
		
		
		locations.get(5).addExit("W", 2);
		locations.get(5).addExit("S", 1);
		//locations.get(5).addExit("Q", 0);
		*/
		Map<String,String> vocabulory = new HashMap<String, String>();
		vocabulory.put("QUIT","Q" );
		vocabulory.put("NORTH","N" );
		vocabulory.put("SOUTH", "S");
		vocabulory.put("EAST", "E");
		vocabulory.put("WEST", "W");
		
		
		
		int loc=64;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc==0) {
				break;
			}
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available exits are: ");
			for(String exit:exits.keySet()) {
				System.out.print(exit+", ");
			}
			System.out.println();
			
			String direction=scanner.nextLine().toUpperCase();
			if(direction.length()>1){
				String[] words=direction.split(" ");
				for(String i:words) {
					if(vocabulory.containsKey(i)) {
						direction=vocabulory.get(i);
						break;
					}
				}
			}
			
			
			if(exits.containsKey(direction)) {
				loc=exits.get(direction);
			}
			else {
				System.out.println("you cannot go in that direction");
			}
			//loc=scanner.nextInt();
			if(!locations.containsKey(loc)) {
				System.out.println("you cannot go in that direction");
				break;
			}
		}
		scanner.close();
		
	}
}
