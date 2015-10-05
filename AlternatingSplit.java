class ListNode5{
	public int data;
	public ListNode5 next;
	
	public ListNode5(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListNode5(int data, ListNode5 n1){
		this.data = data;
		this.next = n1;
	}
}

class LinkedList3{
	ListNode5 head = null;
	
	public void addLast(int data){
		ListNode5 curr = null;
		if(head == null){
			head = new ListNode5(data);
		}
		else
		{
			curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new ListNode5(data);
		}
	}
	
	public String toString(){
		ListNode5 nodeRef = head;
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

class ResultList{
	LinkedList3 a;
	LinkedList3 b;
	
	public ResultList(){
		a = new LinkedList3();
		b = new LinkedList3();
	}
}

public class AlternatingSplit{
	public ResultList getAlternatingSplit(LinkedList3 List){
		ListNode5 head = List.head;
		ListNode5 curr = head;
		//ListNode5 even = head.next;
		ResultList l = new ResultList();
		
		if(head == null){
			return null;
		}
		else{
			while(curr.next != null){
				l.a.addLast(curr.data);
				l.b.addLast(curr.next.data);
				curr = curr.next.next;
			}
			l.a.addLast(curr.data);
		}
		return l;
	}
	
	public static void main(String[] args){
		
		LinkedList3 l = new LinkedList3();
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(4);
		l.addLast(5);
		l.addLast(6);
		l.addLast(7);
		l.addLast(8);
		l.addLast(9);
		System.out.print(l.toString());
		System.out.println();
		AlternatingSplit obj = new AlternatingSplit();
		ResultList r = obj.getAlternatingSplit(l);
		System.out.print(r.a.toString());
		System.out.println();
		System.out.print(r.b.toString());
		
	}
}
