package tree.leafNodesInOrder;

import java.util.LinkedList;

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

/**
 * DFS traversal
 * We could also do BFS 
 */
public class InOrderLeafNodes {
	
	LinkedList<Node> getLeafNodesInOrder(Node root){
		if(root == null)	return null;
		LinkedList<Node> out = new LinkedList<>();
		inOrderHelper(root, out);
		return out;
	}
	
	void inOrderHelper(Node root, LinkedList<Node> list){
		if(root == null)	return;
		
		if(root.left==null && root.right==null)
			list.add(root);
		if(root.left!=null)
			inOrderHelper(root.left, list);
		if(root.right!=null)
			inOrderHelper(root.right, list);
	}
	
	public static void main(String[] args) {		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n4.left = n2;	n4.right = n5;
		n2.left = n1;	n2.right = n3;		
		n5.right = n6;
		
		LinkedList<Node> out = new InOrderLeafNodes().getLeafNodesInOrder(n4);
		for(Node n : out){
			System.out.print(n.value+"->");
		}
		System.out.println();
	}

}
