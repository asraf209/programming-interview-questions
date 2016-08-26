package tree.flattenBTree;

import java.util.LinkedList;

public class FlattenBTree {
	
	class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public LinkedList<TreeNode> flatten(TreeNode root) {
		if(root==null)	return null;
		LinkedList<TreeNode> out = new LinkedList<>();
        flattenHelper(root, out);
        return out;
    }
	
	public void flattenHelper(TreeNode root, LinkedList<TreeNode> list){
		if(root == null)	return;
		
		list.add(root);
		if(root.left!=null)
			flattenHelper(root.left, list);
		if(root.right!=null)
			flattenHelper(root.right, list);
	}

	public static void main(String[] args) {
		
	}

}
