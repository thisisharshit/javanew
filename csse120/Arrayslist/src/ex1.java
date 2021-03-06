import java.util.ArrayList;
import java.util.Scanner;

public class ex1 {
	private static Scanner scan =  new Scanner(System.in);
	private static Mobilephone mobilephone = new Mobilephone("75972893921");
	public static void main(String[] args) {
		boolean quit = false;
		startphone();
		printactions();
		while(!quit) {
			System.out.println("\n\nenter action: ");
			int action  = scan.nextInt();
			scan.nextLine();
			switch (action) {
			case 0:
				System.out.println("shutting down...");
				quit=true;
				break;
			case 1:
				mobilephone.printcontacts();
				break;
			case 2:
				addcontact();
				break;
			case 3:
				updatecontact();
				break;
			case 4:
				removecontact();
				break;
			case 5:
				querycontact();
				break;
			default:
				printactions();
				break;
			}
		}
	}
	private static void startphone() {
		System.out.println("starting phone....");
	}
	private static void printactions() {
		System.out.println("available actions...\nPress");
		System.out.println("0 - to shutdown\n"+
		"1 - to print contacts\n"+"2 - to add new contact\n"+"3 - to update existing contact\n"+"4 - to remove existing contact\n"+
				"5 - query a contact\n"+"6 - to print list of available actions");
		System.out.print("choose your action: ");
	}
	private static void addcontact() {
		System.out.print("enter new contact name: ");
		String name  =  scan.nextLine();
		System.out.print("enter phone num: ");
		String num = scan.nextLine();
		Contacts newcontact =new Contacts(name, num);
		System.out.println(name+" "+num+" added");
		if(mobilephone.addnew(newcontact)==true) {
			System.out.println("new contact added");
		}else {
			System.out.println("cant add contact, already present");
		}
	}
	private static void updatecontact() {
		System.out.print("enter existing contact name: ");
		String name  =  scan.nextLine();
		Contacts exist = mobilephone.query(name);
		if(exist==null) {
			System.out.println("contact not found");
			return;
		}
		System.out.print("enter new contact name: ");
		String newname=scan.nextLine();
		if(mobilephone.query(newname)!=null) {
			System.out.println("cant update an existing contact");
			return;
		}
		System.out.print( "enter new contact number: ");
		String newnum= scan.nextLine();
		Contacts newcontact = new Contacts(newname, newnum);
		if(mobilephone.update(exist, newcontact)) {
			System.out.println("succesfully updated record");
		}
		else {
			System.out.println("error updating contact");
		}
	}
	private static void removecontact() {
		System.out.print("enter existing contact name: ");
		String name  =  scan.nextLine();
		Contacts exist = mobilephone.query(name);
		if(exist==null) {
			System.out.println("contact not found");
			return;
		}
		if(mobilephone.remove(exist)) {
			System.out.println("successfully removed");
		}else {
			System.out.println("error deleting contact");
		}
	}
	private static void querycontact() {
		System.out.print("enter existing contact name: ");
		String name  =  scan.nextLine();
		Contacts exist = mobilephone.query(name);
		if(exist==null) {
			System.out.println("contact not found");
			return;
		}
		System.out.println("name: "+exist.getName()+", phone number is: "+exist.getNum());
		
	}
}
class Contacts{
	private String name;
	private String num;
	public Contacts(String name, String num) {
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
class Mobilephone{
	private String  mynumber;
	private ArrayList<Contacts> mycontacts;
	
	
	public Mobilephone(String mynumber) {
		this.mynumber = mynumber;
		this.mycontacts = new ArrayList<Contacts>();
	}
	public void printcontacts() {
		System.out.println("contact list:- ");
		for(int i=0;i<this.mycontacts.size();i++) {
			System.out.println((i+1)+". "+this.mycontacts.get(i).getName()+" -> "+this.mycontacts.get(i).getNum());
		}
	}
	public boolean addnew(Contacts contact) {
		if(findcontact(contact)>=0) {
			System.out.println("already present");
			return false;
		}else {
			this.mycontacts.add(contact);
			return true;
		}
	}
	
	private int findcontact(Contacts contact) {
		return this.mycontacts.indexOf(contact);
	}
	private int findcontact(String name) {
		for(int i=0;i<mycontacts.size();i++) {
			Contacts contact = mycontacts.get(i);
			if(contact.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public String query(Contacts contact) {
		if(findcontact(contact)>=0) {
			return contact.getName();
		}
		return null;
	}
	public Contacts query(String name) {
		int pos  = findcontact(name);
		if(pos>=0) {
			return this.mycontacts.get(pos); 
		}
		return null;
	}
	public boolean remove(Contacts contact) {
		int pos = findcontact(contact);
		if(pos<0) {
			System.out.println("not found");
			return false;
		}
		else {
			this.mycontacts.remove(pos);
			System.out.println(contact.getName()+" was deleted");
			return true;
		}
	}
	public boolean update(Contacts oldcontact, Contacts newcontact) {
		int pos = findcontact(oldcontact);
		if(pos<0) {
			System.out.println("not found");
			return false;
		}
		else {
			this.mycontacts.set(pos, newcontact);
			System.out.println("old contact was replaced with new contact");
			return true;
		}
			
	}
		
}