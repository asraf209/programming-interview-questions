package linkedlist.addNodeToCircularTail;

public class AddNodeToTail {

	static class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	/**
	 * Create the new Node
	 * Point Head's next to the next of NewNode
	 * Point Head.next to NewNode
	 * Swap their Node values 
	 * Make NewNode as the Head
	 * @param head
	 * @param value
	 */
	public static void addNodeToTailInCircularList(Node head, int value){
		if(head == null){
			head = new Node(value);
			head.next = head;
		}		
		else{
			Node newNode = new Node(value);	
			newNode.next = head.next;
			head.next = newNode;
			
			int tmp = head.value;
			head.value = newNode.value;
			newNode.value = tmp;
			
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
