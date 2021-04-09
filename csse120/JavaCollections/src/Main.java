import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {
	public static void main(String[] args) {
		Theatre theatre=new Theatre("PVR", 8, 12);
		
		if(theatre.reserveseat("D12")) {
			System.out.println("please pay for D12");
		}else {
			System.out.println("seat is already reserved");
		}
		if(theatre.reserveseat("B13")) {
			System.out.println("please pay for B13");
		}else {
			System.out.println("seat is already reserved");
		}
		
		List<Theatre.Seat> reverseSeates=new ArrayList<Theatre.Seat>(theatre.getSeats());
		Collections.reverse(reverseSeates);
		printlist(reverseSeates);
		
		List<Theatre.Seat> priceSeates=new ArrayList<Theatre.Seat>(theatre.getSeats());
		priceSeates.add(theatre.new Seat("B00", 13.00));
		priceSeates.add(theatre.new Seat("A00", 13.00));
		Collections.sort(priceSeates, theatre.price_order);
		printlist(priceSeates);
		
		
		
		/*theatre.getseats();
		if(theatre.reserveseat("H11")) {
			System.out.println("please pay");
		}else {
			System.out.println("seat is taken");
		}
		if(theatre.reserveseat("H14")) {
			System.out.println("please pay");
		}else {
			System.out.println("seat is taken");
		}*/
		/*
		List<Theatre.Seat> seatcopy=new ArrayList<>(theatre.seats);//shallowcopy
		printlist(seatcopy);
		seatcopy.get(1).reserve();
		if(theatre.reserveseat("A02")) {
			System.out.println("please pay for seat A02");
		}
		else {
			System.out.println("Seat already reserved");
		}
		//Collections.reverse(seatcopy);
		Collections.shuffle(seatcopy);
		System.out.println("printing seatcopy");
		printlist(seatcopy);
		System.out.println("printing theatre.seat");
		printlist(theatre.seats);
		*/
		
		//System.out.println("printing sorted order");
		//sortlist(seatcopy);
		//printlist(seatcopy);
		
		/*
		List<Theatre.Seat> newlist=new ArrayList<Theatre.Seat>(theatre.seats);
		Collections.copy(newlist, seatcopy);
		printlist(newlist);
		*/
	}
	public static void printlist(List<Theatre.Seat> list) {
		for(Theatre.Seat seat:list) {
			System.out.print(" "+seat.getseatnumber()+" "+seat.getPrice());
		}
		System.out.println();
		System.out.println("===========================================");
	}
	public static void sortlist(List<? extends Theatre.Seat> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).compareTo(list.get(j))>0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}
}
