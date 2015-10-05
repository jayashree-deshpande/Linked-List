class ListNode4{
	public int data;
	public ListNode4 next;
	
	public ListNode4(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListNode4(int data, ListNode4 n1){
		this.data = data;
		this.next = n1;
	}
}

class LinkedList2{
	ListNode4 head = null;
	
	public void addLast(int data){
		ListNode4 curr = null;
		if(head == null){
			head = new ListNode4(data);
		}
		else
		{
			curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new ListNode4(data);
		}
	}
	
	public String toString(){
		ListNode4 nodeRef = head;
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

public class DeleteAlternateNodes{
	public void delAlternate(LinkedList2 l){
		if(l.head == null){
			return;
		}
		
		ListNode4 curr = l.head;
		ListNode4 temp = l.head.next.next;
		
		while(temp.next != null){
			System.out.println("curr is " + curr.data);
			curr.next = temp;
			System.out.println("curr.next is " + curr.next.data);
			curr = curr.next;
			temp = temp.next.next;
		}
		curr.next = temp;
		curr = curr.next;
	}
	
	public static void main(String[] args){
		
		LinkedList2 a = new LinkedList2();
		a.addLast(1);
		a.addLast(2);
		a.addLast(3);
		a.addLast(4);
		a.addLast(5);
		a.addLast(6);
		a.addLast(7);
		a.addLast(8);
		a.addLast(9);
		System.out.print(a.toString());
		DeleteAlternateNodes obj = new DeleteAlternateNodes();
		obj.delAlternate(a);
		System.out.print(a.toString());
		
	}
}
