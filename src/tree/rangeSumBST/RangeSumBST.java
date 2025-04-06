package tree.rangeSumBST;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
	static int sum;

	public static int getRangeSumRecursive(TreeNode root, int low, int high){
		if (root==null)	return	0;
		sum=0;
		getRangeSumHelper(root, low, high);
		return sum;
	}

	// This implementation will work for any binary tree, not only BST
	private static void getRangeSumHelper(TreeNode n, int low, int high) {
		if (n==null)	return;
		if (isValueWithinRange(n, low, high))	sum+=n.value;
		getRangeSumHelper(n.left, low, high);
		getRangeSumHelper(n.right, low, high);
	}

	// Optimized for BST
	private static void getRangeSumHelperOptimizedForBST(TreeNode n, int low, int high) {
		if (n==null)	return;
		if (n.value>=low && n.value<=high)	sum+=n.value;
		if (n.value > low) getRangeSumHelper(n.left, low, high);
		if (n.value < high) getRangeSumHelper(n.right, low, high);
	}

	private static boolean isValueWithinRange(TreeNode n, int low, int high) {
		if (n==null)	return false;
		return n.value>=low && n.value<=high;
	}

	// Iterative with BFS search
	// Change the Queue to Stack for DFS
	public static int getRangeSumIterative(TreeNode root, int low, int high){
		if (root==null)	return	0;
		int sum=0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();
			if (n.value>=low && n.value<=high)	sum+=n.value;
			if (n.value > low && n.left!=null) queue.offer(n.left);
			if (n.value < high && n.right!=null) queue.offer(n.right);
		}

		return sum;
	}

	public static void main(String[] args) {
		// Example 1
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(18);

		n1.left  = n2;
		n1.right = n3;
		n2.left  = n4;
		n2.right = n5;
		n3.right = n6;

		System.out.println(getRangeSumRecursive(n1, 7, 15));
		System.out.println(getRangeSumIterative(n1, 7, 15));

		// Example 2
		n1 = new TreeNode(10);
		n2 = new TreeNode(5);
		n3 = new TreeNode(15);
		n4 = new TreeNode(3);
		n5 = new TreeNode(7);
		n6 = new TreeNode(13);
		TreeNode n7 = new TreeNode(18);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(6);
		
		n1.left  = n2;
		n1.right = n3;
		n2.left  = n4;
		n2.right = n5;
		n3.left  = n6;
		n3.right  = n7;
		n4.left  = n8;
		n5.left  = n9;

		System.out.println(getRangeSumRecursive(n1, 6, 10));
		System.out.println(getRangeSumIterative(n1, 6, 10));
	}
}
