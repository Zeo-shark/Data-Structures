package LinkedList;
import java.util.*;
public class SplitlistCLL {
	Node head, head1,head2;
	static final Scanner sc= new Scanner(System.in);
	
	static class Node{
		int data;
		Node next, prev;
		Node(int data)
		{
			this.data= data;
			next= prev= null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitCLL list= new SplitCLL();
		
		list.head= new Node(12);
		list.head.next= new Node(11);
		list.head.next.next= new Node(56);
		list.head.next.next.next= new Node(23);
		list.head.next.next.next.next= new Node(77);
		
		System.out.println("Print the list");
		list.printlist(head);
		
		list.splitlist
		
	}

}
