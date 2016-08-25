package tree.sumRootToLeafNumbers;

/**
 * DFS traversal. 
 * 1) At each node, populate the number itself bu computing (10*res + digit) formula
 * 2) When reach to a leaf node compute the total sumSince i
 * 3) It's a recursive algorithm and we will finish when all nodes are traversed. And there is no other exit condition here.
 * 	  So instead of returning from the recursive function, we made a wrapper class Total, which will be populating each time we hit a leaf node
 */
public class SumOfRootToLeafNumbers {
	
	class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	class Total{
		int value;
		public Total()	{this.value = 0;}
	}
	
	public int sumNumbers(TreeNode root) {
        if(root==null)	return 0;
        Total total = new Total();
        sumNumbersHelper(root, total, 0);
        return total.value;
    }
		
	public void sumNumbersHelper(TreeNode root, Total total, int num){
		if(root == null)	return;
		
		num = 10*num + root.val;
		if(root.left==null && root.right==null)
			total.value += num;
		if(root.left!=null)
			sumNumbersHelper(root.left, total, num);
		if(root.right!=null)
			sumNumbersHelper(root.right, total, num);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
