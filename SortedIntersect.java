class ListNode3{
	public int data;
	public ListNode3 next;
	
	public ListNode3(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListNode3(int data, ListNode3 n1){
		this.data = data;
		this.next = n1;
	}
}

class LinkedList1{
	ListNode3 head = null;
	
	public void addLast(int data){
		ListNode3 curr = null;
		if(head == null){
			head = new ListNode3(data);
		}
		else
		{
			curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new ListNode3(data);
		}
	}
	
	public String toString(){
		ListNode3 nodeRef = head;
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


public class SortedIntersect{
	
	public LinkedList1 getSortedIntersect(LinkedList1 l1, LinkedList1 l2){
		ListNode3 cur1 = l1.head;
		ListNode3 cur2 = l2.head;
		LinkedList1 l3 = new LinkedList1();
		
		if(l1.head == null ){
			return l2;
		}
		else if(l2.head == null){
			return l1;
		}
		else{
			while(cur1!= null && cur2!=null){
				//System.out.println("---1---");
				if(cur1.data == cur2.data){
					//System.out.println("---2---");
					l3.addLast(cur1.data);
					cur1 = cur1.next;
					cur2 = cur2.next;
				}
				else if(cur1.data < cur2.data){
					cur1 = cur1.next;
				}
				else{
					cur2 = cur2.next;
				}
			}
		}
		return l3;
	}
	
	public static void main(String[] args){
		
		LinkedList1 a = new LinkedList1();
		a.addLast(1);
		a.addLast(2);
		a.addLast(3);
		a.addLast(4);
		a.addLast(6);
		System.out.print(a.toString());
		

		LinkedList1 b = new LinkedList1();
		b.addLast(2);
		b.addLast(4);
		b.addLast(6);
		b.addLast(8);
		System.out.println();
		System.out.print(b.toString());
		
		SortedIntersect obj = new SortedIntersect();
		LinkedList1 c= obj.getSortedIntersect(a, b);
		System.out.println();
		System.out.print(c.toString());
		
	}
	
}
