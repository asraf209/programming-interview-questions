package tree.leafNodesInOrder;

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class InOrderLeafNodes {
	
	public static void main(String[] args) {
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n4.left = n2;	n4.right = n5;
		n2.left = n1;	n2.right = n3;
		n1.left = n0;	
		n5.right = n6;
	}

}
