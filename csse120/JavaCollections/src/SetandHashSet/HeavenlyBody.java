package SetandHashSet;
import java.util.*;
public final class HeavenlyBody {
	private final String name;
	private final double orbintalPeriod;
	private final Set<HeavenlyBody> satellites;
	public HeavenlyBody(String name, double orbintalPeriod) {
		this.name=name;
		this.orbintalPeriod=orbintalPeriod;
		this.satellites=new HashSet<HeavenlyBody>();
	}
	public String getName() {
		return name;
	}
	public double getOrbintalPeriod() {
		return orbintalPeriod;
	}
	public boolean addmoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<HeavenlyBody>(this.satellites);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("equals called");
		if(this==obj) {
			return true;
		}
		System.out.println("object.getclass() is "+obj.getClass());

		System.out.println("this.getclass() is "+this.getClass());
		if(obj==null || obj.getClass() != this.getClass()) {
			return false;
		}
		String objname=((HeavenlyBody)obj).getName();
		return name.equals(objname);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("hashcode called");
		return this.name.hashCode();
	}
	
	
}
