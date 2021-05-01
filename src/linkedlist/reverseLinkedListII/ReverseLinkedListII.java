package linkedlist.reverseLinkedListII;

public class ReverseLinkedListII {
	class Node{
		int value;
		Node next;
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	public Node makeAList(int[] a){
		Node out=null;
		Node curr = out;
		for(int i=0; i<a.length; i++){
			if(out==null){
				out = new Node(a[i]);
				curr = out;
			}
			else{
				curr.next = new Node(a[i]);
				curr = curr.next;
			}
		}
		return out;
	}		
	
	public static void printList(Node head){
		while(head!=null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	Node reverseLinkedListII(Node head, int left, int right) {
		if (head==null || head.next==null)	return head;
		
		// Use 2 nodes strategy. Create a chunk of (right-left)
		Node n1=head, n2=head;
		int gap = right - left;
		int i=0;
		while(i<gap && n2!=null) {	
			n2=n2.next;
			i++;
		}
		
		if (n2==null)	return head;
		
		// Move the chunk to right position
		i=1;
		Node n1Left=null;
		while(i<left) {
			n1Left = n1;
			n1=n1.next;
			n2=n2.next;
			i++;
		}
		
		Node n2Next = n2.next;
		n2.next = null;	// Nullify chunk tail for easier processing
		
		Node reversedList = this.reverseList(n1, n2, n2Next);
		if(n1Left!=null) {
			n1Left.next = reversedList;
			return head;
		}
		
		return reversedList;
	}
	
	Node reverseList(Node head, Node tail, Node tailNext) {
		Node newHead = null, newTail= null;
		Node headNext=null;
		
		while(head!=null) {
			headNext = head.next;
			if(newHead==null) {
				newHead = head;
				newTail = newHead;
			}
			else {
				head.next = newHead;
				newHead = head;
			}
			
			head = headNext;
		}
		
		newTail.next = tailNext;
		return newHead;
	}
	
	public static void main(String[] args) {		
		// Example 1
		int[] a = {1, 2, 3, 4, 5};	
		int left=1, right=5;
		
		ReverseLinkedListII obj = new ReverseLinkedListII();
		Node head = obj.makeAList(a);
		printList(head);
		
		Node res = obj.reverseLinkedListII(head, left, right);
		printList(res);
		
		// Example 2
		int[] b = {5};
		left=1; right=1;
		
		head = obj.makeAList(b);
		printList(head);
		
		res = obj.reverseLinkedListII(head, left, right);
		printList(res);
	}
}
