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
	
	public void printList(Node head){
		while(head!=null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("NULL \n");
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
		Node head = obj.makeAList(a);
		obj.printList(head);
		
		head = obj.reverseListWithExtraSpace(head);
		obj.printList(head);
	}

}
