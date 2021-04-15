package tree.traverseBTSpiralOrder;

import java.util.*;
import java.util.Stack;

public class TraverseBTInSpiralOrder {
	
	/**
	 * O(n); n - number of Node's in Binary Tree
	 * We can also use one Stack and one Queue
	 * @param root
	 */
	public static void printBTinSpiralOrder(Node root){
		if(root == null)	return;
		Stack<Node> s1 = new Stack<>();	// Right to Left
		Stack<Node> s2 = new Stack<>();	// Left to Right
		
		s1.push(root);
		while(s1!=null || s2!=null){
			while(!s1.isEmpty()){
				Node n = s1.pop();
				System.out.println(n.value);
				
				if(n.right!=null)	s2.push(n.right);
				if(n.left!=null)	s2.push(n.left);				
			}
			
			while(!s2.isEmpty()){
				Node n = s2.pop();
				System.out.println(n.value);
								
				if(n.left!=null)	s1.push(n.left);
				if(n.right!=null)	s1.push(n.right);
			}
		}
	}
	
	/**
	* This can also be done using one Stack and one Queue
	* Stack to handle odd level Nodes and Queue to handle even level Nodes
	*/
	public static void printBTinSpiralOrder2(Node root){
		if(root == null)	return;
		Stack<Node> stack = new Stack<>();	// Odd level nodes
		Queue<Node> queue = new LinkedList<>(); // Even level nodes
		
		stack.push(root);
		while(!stack.isEmpty() || !queue.isEmpty()){
			while(!stack.isEmpty()){
				Node n = stack.pop();
				System.out.println(n.value);
				
				if(n.left!=null)	queue.add(n.left);
				if(n.right!=null)	queue.add(n.right);
			}
			
			while(!queue.isEmpty()){
				Node n = queue.poll();
				System.out.println(n.value);
								
				if(n.left!=null)	stack.push(n.left);
				if(n.right!=null)	stack.push(n.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);	
		
		n1.left = n2;
		n1.right = n3;		
		n2.left = n7;
		n2.right = n6;		
		n3.left = n5;
		n3.right = n4;
		
		printBTinSpiralOrder(n1);
	}

}
