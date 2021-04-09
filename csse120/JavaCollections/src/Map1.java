import java.util.HashMap;
import java.util.Map;

public class Map1 {
	
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<>();
		m.put("Java", "OO programing");
		m.put("pyhon","zywefd");
		m.put("algol", "qerqef");
		m.put("BASIC", "begineers");
		m.put("lisp", "madness");
		
		System.out.println(m.put("java","sdf"));
		 if(m.containsKey("java")) {
			 System.out.println("already present");
		 }else {
			 m.put("java","sdfasd");
		 }
		 System.out.println("----------------------------------------");
		 for(String key:m.keySet()) {
			 System.out.println(key+": "+m.get(key));
		 }
	}
}
