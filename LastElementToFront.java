class ListNode2{
	public int data;
	public ListNode2 next;
	
	public ListNode2(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListNode2(int data, ListNode2 n1){
		this.data = data;
		this.next = n1;
	}
}

class LinkedList{
	ListNode2 head = null;
	
	public void addLast(int data){
		ListNode2 curr = null;
		if(head == null){
			head = new ListNode2(data);
		}
		else
		{
			curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new ListNode2(data);
		}
	}
	
	public String toString(){
		ListNode2 nodeRef = head;
		StringBuilder result = new StringBuilder();
		while(nodeRef != null){
			result.append(nodeRef.data);
			if(nodeRef.next != null){
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}
}

public class LastElementToFront{
	
	public void moveToFront(LinkedList l){
		/* If linked list is empty, or it contains only one node, 
		   then nothing needs to be done, simply return */  
		if(l.head == null || l.head.next == null){
			return;
		}
		  
		/* Initialize second last and last pointers */ 
		ListNode2 secLast = null;
		ListNode2 last = null;
		ListNode2 curr = l.head;
		
		/*After this loop secLast contains address of second last
		node and last contains address of last node in Linked List */
		
		while(curr.next.next != null)  
		{
			curr = curr.next; 
		}                 
		
		secLast = curr;
		last = curr.next;
		System.out.println(" \n" + curr.data +" " + curr.next.data);
		
		secLast.next = null;
		last.next = l.head;
		l.head = last;
	}     
	
	public static void main(String[] args){
		
		LinkedList l = new LinkedList();
		l.addLast(2);
		l.addLast(4);
		l.addLast(6);
		l.addLast(8);
		l.addLast(10);
		
		System.out.print(l.toString());
		//System.out.println(l.head.data);
		LastElementToFront obj = new LastElementToFront();
		obj.moveToFront(l);
		System.out.println();
		System.out.print(l.toString());
		//System.out.println(l.head.data);
	}
	
}
