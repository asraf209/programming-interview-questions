package linkedlist.rotateLinkedList;

public class RotateLinkedList {
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
	
	/**
	 * The idea is to first identify the chunk. And then move the chunk to the beginning of the list
	 */
	public Node rotateKPlacesToRight(Node head, int k){
		if(head==null || head.next==null || k<1)
			return head;
		
		Node n1 = head, n2 = head;
		int i = 1;
		
		// Make k distance gap between nodes n1, n2 
		while (i<k && n2!=null) {
			n2 = n2.next;
			i++;
		}
		
		// Incase of k>(total # of nodes) 
		if (n2==null)	return rotateKPlacesToRight(head, (k%(i-1)));
		
		// Move them to the very end
		Node n1Left = null;
		while (n2.next!=null) {
			n1Left = n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		// Remove the chunk from the main list
		n1Left.next = n2.next;
		
		// Add the chunk to the beginning of the list
		n2.next = head;
		head = n1;
		
		return head;
	}
	
	public static void main(String[] args) {		
		// Example 1
		int[] a = {1, 2, 3, 4, 5};
		RotateLinkedList obj = new RotateLinkedList();
		Node head = obj.makeAList(a);
		printList(head);
		
		int k = 2;
		Node newHead = obj.rotateKPlacesToRight(head, k);
		printList(newHead);
		
		// Example 2
		int[] b = {0, 1, 2};
		head = obj.makeAList(b);
		printList(head);
		
		k = 4;
		newHead = obj.rotateKPlacesToRight(head, k);
		printList(newHead);
	}
}
