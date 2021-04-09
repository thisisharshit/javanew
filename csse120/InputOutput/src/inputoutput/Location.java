package inputoutput;

import java.util.HashMap;
import java.util.Map;

public class Location {
	private final int loctionid;
	private final String description;
	private final Map<String, Integer> exits;
	public Location(int loctionid, String description) {
		
		this.loctionid = loctionid;
		this.description = description;
		this.exits=new HashMap<String, Integer>();
		this.exits.put("Q", 0);
	}
	public void addExit(String direction, int location) {
		exits.put(direction,location);
	}
	public int getLoctionid() {
		return loctionid;
	}
	public String getDescription() {
		return description;
	}
	public Map<String, Integer> getExits() {
		//return exits;
		return new HashMap<String, Integer>(exits);
	}
	
	
}
