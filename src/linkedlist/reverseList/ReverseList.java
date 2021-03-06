package linkedlist.reverseList;

import java.util.Stack;

public class ReverseList {
	class Node{
		int value;
		Node next;
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	/**
	 * Time: O(2n)
	 * Space: O(n)
	 * @param head
	 * @return
	 */
	public Node reverseListWithExtraSpace(Node head){
		if(head == null || head.next==null)
			return head;
		
		Stack<Integer> stack = new Stack<>();
		while(head!=null){
			stack.push(head.value);
			head = head.next;
		}
		
		Node out=null;
		Node curr = out;
		while(!stack.isEmpty()){
			if(out==null){
				out = new Node(stack.pop());
				curr = out;
			}
			else{
				curr.next = new Node(stack.pop());
				curr = curr.next;
			}
		}
		return out;
	}
	
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * @param head
	 * @return
	 */
	public Node reverseListWithoutExtraSpace(Node head){
		if(head == null || head.next==null)
			return head;
		
		Node newHead = null;
		while(head != null){
			Node n = head;
			head = head.next;	// Move forward the head pointer
			n.next = null;		// Free up the node
			
			// Add that free node to the new list
			if(newHead == null)
				newHead = n;
			else{
				n.next = newHead;
				newHead = n;
			}
		}
		
		return newHead;
	}
	
	public void printList(Node head){
		while(head!=null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("NULL");
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
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		ReverseList obj = new ReverseList();
		Node head1 = obj.makeAList(a);
		obj.printList(head1);		
		head1 = obj.reverseListWithExtraSpace(head1);
		obj.printList(head1);
		
		System.out.println();
		
		Node head2 = obj.makeAList(a);
		obj.printList(head2);
		head2 = obj.reverseListWithoutExtraSpace(head2);
		obj.printList(head2);
	}

}
