package tree.kthLargest;

public class KthLargest {
	
	private int count = 0;
	
	public void kthLargest(Node root, int k){
		if(root==null)	return;
		
		if(root.right!=null)
			kthLargest(root.right, k);
		
		count++;
		if(k == count){
			System.out.println("k=" + k + ", value: " + root.value);
			return;
		}
		
		if(root.left!=null)
			kthLargest(root.left, k);		
	}		
	
	public void findKthLargest(Node root, int k){
		count = 0;
		kthLargest(root, k);
	}
	
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
		
		KthLargest obj = new KthLargest();
		obj.findKthLargest(n1, 1);
		obj.findKthLargest(n1, 3);
		obj.findKthLargest(n1, 5);
	}

}
