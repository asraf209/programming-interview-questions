package linkedlist.reverseKNodes;

import java.util.Stack;

public class ReverseKNodes {
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
	
	/**
	 * Using Stack. Read elements and push into Stack.
	 * Then read back from Stack and make a list
	 * Time: O(n)
	 * Space: O(n)
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reverseKNodesFromHead(Node head, int k){
		if(head==null || head.next==null || k<2)
			return head;
		
		Stack<Integer> stack = new Stack<>();
		Node curr = head;
		int count=0;
		while(curr!=null && count<k){
			stack.push(curr.value);
			curr = curr.next;
			count++;
		}
		
		Node newHead = null;
		Node tail = newHead;				
		while(!stack.isEmpty()){
			Node n = new Node(stack.pop());
			if(newHead==null){
				newHead = n;
				tail = n;
			}
			else{
				tail.next = n;
				tail = tail.next;
			}
		}
		tail.next = curr;
		
		return newHead;
	}
	
	public static void printList(Node head){
		while(head!=null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {		
		int[] a = {1, 2, 3, 4, 5};
		ReverseKNodes reverseKNodes = new ReverseKNodes();
		Node head = reverseKNodes.makeAList(a);
		printList(head);
		
		int k = 30;
		Node newHead = reverseKNodes.reverseKNodesFromHead(head, k);
		printList(newHead);
	}

}
