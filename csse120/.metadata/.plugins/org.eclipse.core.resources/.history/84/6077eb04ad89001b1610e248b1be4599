import java.util.Arrays;

public class Linkedlists {
	
	
	
	public static void traversell(Listnode head) {
		if(head== null) return;
		
		Listnode temp=head;
		while(temp!=null){
			System.out.println(temp.getData());
			//temp=temp.getNext();
			temp=temp.getNext();
		}
	}
	public static int Length(Listnode head) {
		int len=0;
		Listnode temp=head;
		while(temp!=null){
			len++;
			temp=temp.next;
		}
		System.out.println(len);
		return 0;
		
	}
	
	public static void main(String args[]) {
		
		Listnode node1 = new Listnode(1);
		
		Listnode node2 = new Listnode(2);
		
		Listnode node3 = new Listnode(3);
		
		Listnode node4 = new Listnode(4);
		Listnode head= new Listnode(5);
		
		Linkedlists obj = new Linkedlists();
		
		LLoperations object = new LLoperations();
		
		
		//node1.setNext(node2)
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		//System.out.println(node1.getData());
		//System.out.println(node1.getNext());
		//traversell(head);
		//obj.Length(node1);
		//Listnode newhead=obj.Insertatstart(node1, 10);
		//traversell(newhead);
		//Listnode newtail=obj.Insertatend(head, 8);
		Listnode newelement=obj.Insertatbw(node3, 15,1);
		
		traversell(node1);
		//Listnode node=obj.deletestart(node1);
		Listnode head1=obj.deleteatk(node1, 2);
		//traversell(head1);
		//obj.Length(newhead);
		
		//System.out.println(node1.getData());
		
		//System.out.println((node2.next).getData());
		
		
	}
	public Listnode Insertatstart(Listnode head, int data) {
		Listnode temp= new Listnode(data);
		temp.next=head;
		return temp;
	}
	//inserting at the end of a inked lists
	public Listnode Insertatend(Listnode head, int data) {
		if(head==null) {
			Listnode node= new Listnode(data);
			return node;
		}
		else {
			Listnode temp = head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Listnode node=new Listnode(data);
			temp.next=node;
			return head;
		}
	}
	public Listnode Insertatbw(Listnode head, int data,int k) {
		
		if(k==1) {
			Listnode node= new Listnode(data);
			node.next=head;
			return node;
		}else {
			int ct=1;
			Listnode temp = head;
			while(ct<k-1) {
				temp=temp.getNext();
				ct++;
			}
			
			
			Listnode node=new Listnode(data);
			
			node.setNext(temp.getNext());
			temp.next=node;
			
			return head;
		}
		
		
	}
	public static Listnode deletestart(Listnode head) {
		if(head==null) {
				return head;
		}
		Listnode nextnode=head.getNext();
		head.next=null;
		head=null;
		
		return nextnode;
	}
	public Listnode deleteatk(Listnode head, int k) {
		if(head==null) {
				return head;
		}
		if(k==1) {
			return deletestart(head);
			
			
		}
		int ct=1;
		Listnode temp= head;
		while(ct<k-1) {
			temp=temp.getNext();
;			ct++;
		}
		Listnode qwerty=temp.getNext();
		temp.next=qwerty.getNext();
		qwerty=null;
		return head;
		
	
	}
	public static class Listnode{
		private int data;
		private Listnode next;
		
		public Listnode(int Listdata) {
			data= Listdata;
			
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Listnode getNext() {
			return next;
		}

		public void setNext(Listnode next) {
			this.next = next;
		}
	}
}

