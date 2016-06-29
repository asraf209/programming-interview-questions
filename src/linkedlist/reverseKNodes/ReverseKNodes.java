package linkedlist.reverseKNodes;

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
	}

}
