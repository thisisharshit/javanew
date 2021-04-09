package EqualsNssubclassing;

public class Labrador extends Dog{

	public Labrador(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) {
			return true;
		}
		if(obj instanceof Labrador) {
			String objname=((Labrador)obj).getName();
			return this.getName().equals(objname);
		}
		return false;
	}
	*/

}
