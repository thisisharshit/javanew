
public class Main {
	public static void main(String[] args) {
		Itelephone myphone = new Deskphone(759728939);
		myphone.poweron();
		myphone.callphone(759728939);
		myphone.answer();
		myphone=new Mobilephone(334);
		myphone.poweron();
		myphone.callphone(1232);
		myphone.answer();
	}

}
