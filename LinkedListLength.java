class ListNode7{
	int data;
	ListNode7 next;
	
	public ListNode7(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList5{
	ListNode7 head = null;
	public void addLast(int data){
		ListNode7 curr = null;
		if(head == null){
			head = new ListNode7(data);
		}
		else{
			curr = head;
			while(curr.next != null)
			{
				curr = curr.next; 
			}
			curr.next = new ListNode7(data);
		}
	}
	
	public String toString(){
		ListNode7 nodeRef = head;
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

public class LinkedListLength{
	public int getLenth(LinkedList5 x){
		ListNode7 curr = x.head;
		int count = 0;
		if(curr == null){
			return 0;
		}
		else{
			while(curr != null){
				count= count+1;
				curr = curr.next;
			}
		}
		return count;
	}
	public static void main(String[] args){
		
		LinkedList5 a = new LinkedList5();
		a.addLast(1);
		a.addLast(3);
		a.addLast(9);
		a.addLast(11);
		a.addLast(13);
		System.out.print(a.toString());
		System.out.println();
		LinkedListLength obj = new LinkedListLength();
		System.out.println("list length is "+obj.getLenth(a));
	}
}
