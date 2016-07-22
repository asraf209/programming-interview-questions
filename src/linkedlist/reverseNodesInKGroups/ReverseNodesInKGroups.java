package linkedlist.reverseNodesInKGroups;

public class ReverseNodesInKGroups {
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	// O(n) overall
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k<2)	return head;
		ListNode p1=head, p2=p1;
		ListNode p1Prev = null;
		
		while(p2!=null){
			int c=1;
			while(c<k && p2!=null){
				p2 = p2.next;
				c++;
			}			
			if(p2!=null){
				ListNode revGroup = reverseList(p1, p2);
				if(p1Prev!=null)	p1Prev.next = revGroup;
				else	head = revGroup;
				
				// List is now reversed. So p1, p2 are already swapped
				p1Prev = p1;
				p1 = p1.next;
				p2 = p1;
			}
		}
		
		return head;
	}	
	
	// O(m)
	private ListNode reverseList(ListNode head, ListNode tail){
		if(head==null || tail==null)	return head;
		ListNode tailNext = tail.next;	// Saving tail's next
		ListNode newHead = head;
		ListNode newTail = newHead;
		
		ListNode p = head.next;		
		while(p!=tail){
			ListNode tmp = p.next;
			p.next = newHead;
			newHead = p;
			p = tmp;
		}		
		p.next = newHead;
		newHead = p;
		
		newTail.next = tailNext;
		
		return newHead;
	}
	
	public static void main(String[] args){
		
	}
}
