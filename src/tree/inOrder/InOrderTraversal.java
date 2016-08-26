package tree.inOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	
	class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
