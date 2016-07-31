package tree.convertBSTtoDLL;

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

public class ConvertBSTtoDLL {
	
	Node head = null;
	Node tail = null;
	
	Node convertToDLL(Node root){
		if(root==null || (root.left==null && root.right==null))
			return root;
		
		convertToDLLHelper(root);
		return head;
	}
	
	void convertToDLLHelper(Node root){
		if(root!=null){
			convertToDLLHelper(root.left);
			
			if(head==null){
				head = root;
				tail = head;
			}
			else{
				tail.right = root;
				root.left = tail;
				tail = tail.right;
			}
			
			convertToDLLHelper(root.right);
		}
	}
	
	static void printDLL(Node head){
		while(head!=null){
			System.out.print(head.value + "<->");
			head = head.right;
		}
		System.out.println();
	}
	
	static void printInOrder(Node root){
		if(root!=null){
			printInOrder(root.left);
			System.out.print(root.value + ", ");
			printInOrder(root.right);
		}		
	}
	
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
		printInOrder(n4);
		System.out.println("\n");
		
		Node dll = new ConvertBSTtoDLL().convertToDLL(n4);
		printDLL(dll);
	}

}
