//Hashing Approach

package LinkedList;
import java.util.*;
public class DetectLoopSLL {

	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int d)
		{data= d;
		next= null;
			
		}
	}
//	Insert new node in the front of the linked list
	static public void push (int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next= head;
		head= new_node;
	}
	
	static boolean detectLoop(Node h)
	{
		HashSet<Node> s= new HashSet<Node>();
		while(h!= null)
		{
			if(s.contains(h))
				return true;
			
			s.add(h);
			h= h.next;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectLoopSLL llist= new DetectLoopSLL();
		llist.push(20);
		llist.push(4);
		llist.push(15);
//		llist.push(10);
		
//	Create a loop for testing
		llist.head.next.next.next.next= llist.head;
		
		if(detectLoop(head))
		{
			System.out.println("Loop found");
		}
		else
		{
			System.out.println("No Loop");
		}
		
	}



//	private static boolean detectLoop(Node head2) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
