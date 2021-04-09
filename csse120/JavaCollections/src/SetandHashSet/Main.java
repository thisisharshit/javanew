package SetandHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	private static Map<String,HeavenlyBody> solarsystem=new HashMap<String, HeavenlyBody>();
	private static Set<HeavenlyBody > planets=new HashSet<HeavenlyBody>();
	public static void main(String[] args) {
		
		HeavenlyBody temp=new HeavenlyBody("mercury",88);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new HeavenlyBody("venus",225);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new HeavenlyBody("earth",365);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		HeavenlyBody tempmoon=new HeavenlyBody("moon",27);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon); //satellites.add(tempmoon)
		
		temp=new HeavenlyBody("mars",687);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		tempmoon=new HeavenlyBody("deimos",1.3);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		tempmoon=new HeavenlyBody("phobos",0.3);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		
		temp=new HeavenlyBody("jupiter",4332);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		tempmoon=new HeavenlyBody("io",1.8);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		tempmoon=new HeavenlyBody("europa",3.5);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		tempmoon=new HeavenlyBody("ganymede",7.1);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		tempmoon=new HeavenlyBody("callisto",16.7);
		solarsystem.put(tempmoon.getName(), tempmoon);
		temp.addmoon(tempmoon);
		
		temp=new HeavenlyBody("saturn",10759);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new HeavenlyBody("uranus",30660);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new HeavenlyBody("neptune",165);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new HeavenlyBody("pluto",248);
		solarsystem.put(temp.getName(), temp);
		planets.add(temp);
		
		System.out.println("planets");
		for(HeavenlyBody planet:planets) {
			System.out.println(planet.getName());
		}
		
		HeavenlyBody body=solarsystem.get("mars");
		System.out.println("moon of "+ body.getName());
		for(HeavenlyBody jupiterMoon:body.getSatellites()) {
			System.out.println("\t"+jupiterMoon.getName());
		}
		Set<HeavenlyBody> moons=new HashSet<HeavenlyBody>();
		for(HeavenlyBody planet:planets) {
			moons.addAll(planet.getSatellites());
		}
		for(HeavenlyBody moon:moons) {
			System.out.println("\t"+moon.getName());
		}
		
		HeavenlyBody pluto = new HeavenlyBody("pluto", 842);
		planets.add(pluto);
		
		for(HeavenlyBody planet:planets) {
			
			System.out.println(planet.getName()+" "+planet.getOrbintalPeriod());
		}
		Object o = new Object();
		System.out.println(o.equals(o));
		System.out.println();
		System.out.println(temp.equals(pluto));
		System.out.println(temp.hashCode()+" "+pluto.hashCode());
	}
}
