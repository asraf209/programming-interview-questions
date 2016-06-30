package tree.kthLargest;

public class KthLargest {

	public static void main(String[] args) {
		Node n1 = new Node(20);
		Node n2 = new Node(8);
		Node n3 = new Node(22);
		Node n4 = new Node(4);
		Node n5 = new Node(12);
		Node n6 = new Node(10);
		Node n7 = new Node(14);	
		
		n1.left = n2;
		n1.right = n3;		
		n2.left = n4;
		n2.right = n5;		
		n5.left = n6;
		n5.right = n7;
	}

}
