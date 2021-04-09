package EqualsNssubclassing;

public class Dog {
	private final String name;
	public Dog(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(this==obj) {
			return true;
		}
		if(obj instanceof Dog) {
			String objname=((Dog)obj).getName();
			return this.name.equals(objname);
		}
		return false;
	}

	
}
