import java.util.ArrayList;

public class arraylist {
	private int[] num;
	ArrayList<String> grocerylist = new ArrayList<String>();
	public void additem(String item) {
		
		grocerylist.add(item);
	}
	public void listsize() {
		System.out.println(grocerylist.size());
		for(int i=0;i<grocerylist.size();i++) {
			System.out.println(i+1+". "+grocerylist.get(i));
			
		}
	}
	public void modifylist(int pos, String item) {
		grocerylist.set(pos, item);
	}
	public void removeitem(int pos) {
		String item=grocerylist.get(pos);
		grocerylist.remove(item);
	}
	public static void main(String args[]) {
		arraylist arraylist = new arraylist();
		arraylist.additem("harshit");
	}
	
}
