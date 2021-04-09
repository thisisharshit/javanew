import java.util.*;

public class Theatre {
	private final String theatre;
	//private List<Seat> seats= new ArrayList<Seat>();
	public List<Seat> seats= new ArrayList<Seat>();
	
	static final Comparator<Seat> price_order= new Comparator<Seat>() {
		
		@Override
		public int compare(Seat o1, Seat o2) {
			// TODO Auto-generated method stub
			if(o1.getPrice()<o2.getPrice()) {
				return -1;
			}
			else if(o1.getPrice()>o2.getPrice()) {
				return 1;
			}
			else {
				return 0;
			}
		}
	};
	
	
	public Theatre(String theatre, int numrows, int seatsperrow) {
		this.theatre=theatre;
		int lastrow='A'+numrows-1;
		for(char row='A';row<=lastrow;row++) {
			for(int seatnum=1;seatnum<=seatsperrow;seatnum++) {
				double price=12.00;
				if((row<'D') && (seatnum>=4 && seatnum<=9)) {
					price=14.00;
				}
				else if((row>'F') || (seatnum<4 || seatnum>9)) {
					price=7.00;
				}
				Seat seat = new Seat(row+String.format("%02d",seatnum),price);
				seats.add(seat);
			}
		}
	}
	public String getTheatre() {
		return theatre;
	}
	public boolean reserveseat(String seatnumber) {
		Seat requestedSeat=new Seat(seatnumber,0);
		int pos = Collections.binarySearch(seats, requestedSeat,null);
		
		if(pos>=0) {
			return seats.get(pos).reserve();
		}
		else {
			System.out.println("there is not seat "+seatnumber);
			return false;
		}
		/*Seat requestedseat=null;
		for(Seat seat:seats) {
			System.out.print(".");
			if(seat.getseatnumber().equals(seatnumber)) {
				requestedseat=seat;
				break;
			}
		}
		if(requestedseat==null) {
			System.out.println("there is no seat "+seatnumber);
			return false;
		}	
		return requestedseat.reserve();
	*/
	}
	/*public void getseats() {
		for (Seat seat:seats) {
			System.out.println(seat.getseatnumber());
		}
	}*/
	public Collection<Seat> getSeats(){
		return seats;
	}
	public class Seat implements Comparable<Seat>{
		
		private final String seatnumber;
		private double price;
		private boolean reserved=false;
		
		public Seat(String seatnumber, double price) {
			this.seatnumber=seatnumber;
			this.price=price;
		}
		
		public boolean reserve() {
			if(!this.reserved) {
				this.reserved=true;	
				System.out.println("Seat "+seatnumber+" reserved");
				return true;
			}else {
				return false;
			}
		}
		
		public boolean cancel() {
			if(this.reserved) {
				this.reserved=false;
				System.out.println("reservation of seat "+seatnumber+" cancelled");
				return true;
			}
			else {
				return false;
			}
		}
		
		public double getPrice() {
			return price;
		}


		public String getseatnumber() {
			return seatnumber;
		}
		
		@Override
		public int compareTo(Seat s) {
			// TODO Auto-generated method stub
			return this.seatnumber.compareToIgnoreCase(s.getseatnumber());
		}
		
	}
}
