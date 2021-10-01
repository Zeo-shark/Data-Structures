package LinkedList;
import java.util.Scanner;

public class SinglyLinkedListAll {

	private static Scanner sc= new Scanner(System.in);
	Node head;
	class Node{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
			next= null;
		}
	}
	//Insert at the beginning
	void push(int d)
	{
//		if linkedlist is empty make head declaration
		if(head== null)
		{
			head= new Node(d);
			return;
		}
		Node newnode= new Node(d);
		
		newnode.next= head;
		
		head= newnode;
		return;
	}
	
	//Insert at the end
	void appendList(int d)
	{
		Node newNode= new Node(d);
		
		Node temp= head;
		while(temp.next==null)
		{
			temp=temp.next;
		}
		temp.next= newNode;
		
		return;
	}
	
	//Insert at the after of a given node
	void insertNode(Node prevNode, int d) {
		//This is important to check if prevNode is exist in LinkedList
		if(prevNode== null)
		{
			System.out.println("Previous Node must not be Null this means it does not exist in LList");
		}
		
		Node newNode= new Node(d);
		
		prevNode.next= newNode.next;
		
		prevNode.next= newNode;
		return;
	}
	
	void printList() {
		Node temp= head;
		
		while(temp != null)
		{
			System.out.println(temp.data+" ");
			temp= temp.next;
		}
	}
	
	void deleteNode(int key) {
		
		Node temp= head, prev= null;
		
		//checking if key found
		if(temp!= null && temp.data== key)
		{
			head= temp.next;
			return;
		}
		//iterating
		while(temp!=null && temp.data!= key )
		{
			prev= temp;
			temp= temp.next;
		}
		//if temp==null
		if(temp==null)
		{
			return;
		}
		
		//result of iteration temp.data== key
		prev.next= temp.next;
	}
	
	void deleteNodePosition(int position) {
		
		if(head== null)
		{
			System.out.println("The List does not exist");
			return;
		}
		
		Node temp= head;
		if(position==0)
		{
			Node head= temp.next;
			return;
		}
		
		for(int i=0;temp!= null && i<position-1;i++)
		{
			temp= temp.next;
		}
		
		//if position is more than nodes we have to insert in the position temp.next
		if(temp==null || temp.next==null)
		{
			return;
		}
		//the next element
		Node next= temp.next.next;
		
		temp.next= next;
		return;
	}
	
	void deleteLList() {
		head= null;
	}
	
	int LengthoftheList() {
		int count=0;
		if(head== null)
		{
			return 0;
		}
		Node temp= head;
		while(temp==null)
		{
			temp= temp.next;
			count++;
		}
		return count;
	}
	
	public boolean searchElement( int x) {
		Node current= head;
		while(current== null)
		{
			if(current.data== x)
			{
				return true;
			}
			current= current.next;
		}
		return false;
	}
	
	void printNthNode(int n) {
		Node current = head;
		for(int i=1;i<=n && current!= null;i++)
		{
			current= current.next;
		}
		System.out.println("The value of the nth Node from the begin is "+current.data);
		
	}
	
	void printLastNthNode(int n) {
		int len=0;
		Node tnode= head;
		while(tnode!=null)
		{
			tnode= tnode.next;
			len++;
		}
		
		if(len< n)
			return;
		
		tnode= head;
		
		for(int i=0;i<len-n;i++)
		{
			tnode= tnode.next;
		}
		
		System.out.print(tnode.data+" ");
	}
	
	public static void main(String args[])
	{
//		Scanner so= new Scanner(System.in);
		SinglyLinkedListAll llist= new SinglyLinkedListAll();
		
		llist.appendList(9);
		llist.appendList(3);
		llist.appendList(4);
		llist.appendList(2);
		
		llist.printList();
		
	}
}
