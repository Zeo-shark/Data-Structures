package LinkedList;

import java.util.*;

public class LoopLengthSLL {

	static class Node{
		int data;
		Node next;
		
		Node(int key){
			data= key;
			next= null;
		}
	}
	
	static int countNodes(Node n)
	{
		int res=1;
		Node temp= n;
		while(temp.next!= n)
		{
			res++;
			temp= temp.next;
		}
		return res;
	}
	
	static Node newNode(int key)
	{
		Node temp = new Node(key);
		
		return temp;
		
		
	}
//	Floyd's Cycle detection algorithm
	static int countNodesinLoop(Node list)
	{
		Node slow_p= list, fast_p= list;
		
		while(slow_p!= null && fast_p!= null && fast_p.next!= null)
		{
			slow_p= slow_p.next;
			fast_p= fast_p.next;
			
			if(slow_p== fast_p)
			{
				return countNodes(slow_p);
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head= newNode(1);
		head.next= newNode(2);
		head.next.next= newNode(3);
		head.next.next.next= newNode(4);
		head.next.next.next.next= head.next;
		
		System.out.println(countNodesinLoop(head));
	}

}
