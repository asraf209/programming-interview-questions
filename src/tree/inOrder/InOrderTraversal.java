package tree.inOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * In-Order Traversal:
 * 		Left
 *		Root
 *		Right
 */
public class InOrderTraversal {
	
	class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	/**
	 * Iterative
	 * Time: O(n)
	 * Space: O(log n)
	 */
	public List<Integer> iterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();               
        List<Integer> list = new ArrayList<>();
        
        TreeNode n = root;
        while(!stack.isEmpty() || n!=null){
        	if(n!=null){
        		stack.push(n);
        		n = n.left;
        	}
        	else{
        		n = stack.pop();
        		list.add(n.val);
        		n = n.right;
        	}
        }
        
        return list;
    }
	
	/**
	 * Recursive
	 * Time: O(n)
	 * Space: O(log n); Consumes Stack space on each recursive call
	 */
	public void recursive1(TreeNode root){
		if(root!=null){
			recursive1(root.left);
			System.out.println(root.val);
			recursive1(root.right);
		}
	}
	
	/**
	 * Recursive
	 * Time: O(n)
	 * Space: O(log n); Consumes Stack space on each recursive call
	 */
	public List<Integer> recursive2(TreeNode root){
		List<Integer> list = new ArrayList<>();
		recursive2Helper(root, list);
		return list;
	}
	
	public void recursive2Helper(TreeNode root, List<Integer> list){
		if(root!=null){
			recursive2Helper(root.left, list);
			list.add(root.val);
			recursive2Helper(root.right, list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
