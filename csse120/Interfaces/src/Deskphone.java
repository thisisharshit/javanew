
public class Deskphone implements Itelephone {
	private int mynumber;
	private boolean isringing;
	
	public Deskphone(int mynumber) {
		this.mynumber=mynumber;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean callphone(int phonenumber) {
		if(phonenumber==mynumber) {
			isringing=true;
			System.out.println("ring ring");
		}else {
			isringing=false;
		}
		return isringing;
	}

	@Override
	public void dial(int phonenumber) {
		System.out.println("now ringing "+phonenumber+" on deskphone");
	}

	@Override
	public void answer() {
		if(isringing) {
			System.out.println("answering the desk phone");
			isringing=false;
		}

	}



	@Override
	public boolean isringing() {
		return isringing;
	}



	@Override
	public void poweron() {
		System.out.println("no actions taken, deskphone does not have a power button");
		
	}
	
}
