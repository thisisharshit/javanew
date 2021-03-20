
public class Mobilephone implements Itelephone {
	private int mynumber;
	private boolean isringing;
	private boolean ison=false;
	public Mobilephone(int mynumber) {
		this.mynumber=mynumber;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean callphone(int phonenumber) {
		if(phonenumber==mynumber && ison) {
			isringing=true;
			System.out.println("melody ring");
		}else {
			isringing=false;
			System.out.println("mobile phone not on or number different");
		}
		return isringing;
	}

	@Override
	public void dial(int phonenumber) {
		if(ison) {
			System.out.println("now ringing "+phonenumber+" on deskphone");
		}else {
			System.out.println("phone is switched off");
		}
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
		ison=true;
		System.out.println("mobile phone powered up");
		
	}

}
