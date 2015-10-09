class ListNode6{
	public int data;
	public ListNode6 next;
	
	public ListNode6(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListNode6(int data, ListNode6 n1){
		this.data = data;
		this.next = n1;
	}
}

class LinkedList4{
	ListNode6 head = null;
	
	public void addLast(int data){
		ListNode6 curr = null;
		if(head == null){
			head = new ListNode6(data);
		}
		else
		{
			curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new ListNode6(data);
		}
	}
	
	public void addFirst(int data){
		ListNode6 curr = new ListNode6(data);
		if(head == null){
			head = curr;
		}
		else
		{
			curr.next = head;
			head = curr;
		}
	}
	
	public String toString(){
		ListNode6 nodeRef = head;
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

public class SortedMerge{
	public LinkedList4 getSortedMerge(LinkedList4 x, LinkedList4 y){
		//LinkedList4 z = new LinkedList4();
		ListNode6 curr1 = x.head;
		ListNode6 curr2 = y.head;
		LinkedList4 z = new LinkedList4();
		
		if(x.head == null){
			return y;
		}
		else if(y.head == null){
			return x;
		}
		else{
			while(curr1 != null && curr2 != null){
				if(curr1.data == curr2.data){
					z.addLast(curr1.data);
					curr1 = curr1.next;
					curr2 = curr2.next;
				}
				else if(curr1.data > curr2.data){
					z.addLast(curr2.data);
					curr2 = curr2.next;
				}
				else{
					z.addLast(curr1.data);
					curr1 = curr1.next;
				}
			}
			
			if(curr1 == null && curr2 != null){
				while(curr2 != null){
					z.addLast(curr2.data);	
					curr2 = curr2.next;
				}
			}
			
			if(curr1 != null && curr2 == null){
				while(curr1 != null){
				z.addLast(curr1.data);	
				curr1 = curr1.next;
				}
			}
					
		}
		return z;
	}
	
	public static void main(String[] args){
		
		LinkedList4 a = new LinkedList4();
		a.addLast(1);
		a.addLast(3);
		a.addLast(9);
		a.addLast(11);
		a.addLast(13);
		System.out.print(a.toString());
		System.out.println();
		
		LinkedList4 b = new LinkedList4();
		b.addLast(2);
		b.addLast(4);
		b.addLast(6);
		b.addLast(8);
		b.addLast(10);
		System.out.print(b.toString());
		
		SortedMerge obj = new SortedMerge();
		LinkedList4 result = obj.getSortedMerge(a, b);
		System.out.println();
		System.out.println(result.toString());
	}
}
