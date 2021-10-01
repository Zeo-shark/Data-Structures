package LinkedList;

public class Even_oddSLL {

	Node head;
	class Node{
		int data;
		Node next;
		Node(int key)
		{
			data= key;
			next= null;
		}
	}
	
	void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next= head;
		head= new_node;
	}
	
	void segregateEvenOdd() {
		Node end= head;
		Node prev= null;
		Node curr= head;
		
		while(end.next!= null)
			end= end.next;
		
		Node new_end= end;
		//odd
		while(curr.data%2!=0 && curr != end)
		{
			new_end.next= curr;
			curr= curr.next;
			new_end.next.next= null;
			new_end= new_end.next;
		}
		
		if(curr.data %2== 0)
		{
			head= curr;
			
			//now curr points to first even node
			while(curr!= end)
			{
				if(curr.data%2 ==0)
				{
					prev=curr;
					curr= curr.next;
				}
				else
				{
					prev.next= curr.next;
//					Make next of curr as null
					curr.next= null;
//					Make curr to the end
					new_end.next= curr;
//					make curr as new end of the list
					new_end= curr;
//					Update curr pointer
					curr= prev.next;
				}
			}
		}
	}
	
	void printlist() {
		Node temp= head;
		while(temp!= null) {
			System.out.print(temp.data+" ");
			temp= temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Even_oddSLL llist= new Even_oddSLL();
		llist.push(11);
		llist.push(10);
		llist.push(8);
		llist.push(6);
		llist.push(3);
		llist.push(2);
		llist.push(0);
		System.out.println("Original Linked List:");
		llist.printlist();
		
		llist.segregateEvenOdd();
		System.out.println(" Modified Linked List:");
		llist.printlist();
		
	}

}
