package inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer,Location>{
	private static Map<Integer, Location> locations=new HashMap<Integer, Location>();
	
	public static void main(String[] args) throws IOException{
		
		try(FileWriter locfile=new FileWriter("locations.txt");
				FileWriter dirfile=new FileWriter("directions.txt")){
			for(Location location : locations.values()) {
				locfile.write(location.getLoctionid()+","+location.getDescription()+"\n");
				for(String direction:location.getExits().keySet()) {
					dirfile.write(location.getLoctionid()+","+direction+","+location.getExits().get(direction)+"\n");
					
				}
			}
		}
		
		
		
		/*FileWriter localFile=null;
		try{
			localFile=new FileWriter("locations.txt");
			for(Location location:locations.values()) {
				localFile.write(location.getLoctionid()+", "+location.getDescription()+'\n');
				throw new IOException("test exception thrown while writing"); 
			}
			localFile.close();
		}finally {
			System.out.println("in finally block");
				if(localFile!=null) {
					System.out.println("attempting to close locfile");
					localFile.close();
				}
		}*/
	}
	
	static {
		
		try(Scanner scanner = new Scanner(new BufferedReader( new FileReader("locations_big.txt")))){
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String des = scanner.nextLine();
				System.out.println("imported loc: "+loc+": "+des);
				Map<String, Integer> tempexit=new HashMap<String, Integer>();
				locations.put(loc, new Location(loc,des));
				//System.out.println(locations.get(loc).getDescription());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try(BufferedReader dirfile=new BufferedReader(new FileReader("directions_big.txt"))){
			//scanner.useDelimiter(",");
			String input;
			while((input=dirfile.readLine())!=null/*scanner.hasNextLine()*/) {
				/*int loc=scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String direction=scanner.next();
				scanner.skip(scanner.delimiter());
				String dest=scanner.nextLine();
				int destination=Integer.parseInt(dest);
				*/
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String direction=data[1];
				int destination=Integer.parseInt(data[2]);
				System.out.println(loc+": "+direction+": "+destination);
				locations.get(loc).addExit(direction, destination);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		/*Scanner scanner=null;
		try {
			scanner = new Scanner(new FileReader("locations_big.txt"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String des = scanner.nextLine();
				System.out.println("imported loc: "+loc+": "+des);
				Map<String, Integer> tempexit=new HashMap<String, Integer>();
				locations.put(loc, new Location(loc,des));
				//System.out.println(locations.get(loc).getDescription());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(scanner!=null) {
				scanner.close(); //file.close() is handled by scanner.close
			}
		}
		
		
		try {
			scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {
				int loc=scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String direction=scanner.next();
				scanner.skip(scanner.delimiter());
				String dest=scanner.nextLine();
				int destination=Integer.parseInt(dest);
				System.out.println(loc+": "+direction+": "+destination);
				locations.get(loc).addExit(direction, destination);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		*/
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
	}
	
	
	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
				
	}

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}
	
}
