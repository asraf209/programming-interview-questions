package tree.invertBTree;

public class InvertBTree {

	class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public TreeNode invertBinaryTree(TreeNode root) {
        if(root==null)  return root;
        root = swap(root, root.left, root.right);
        if(root.left!=null) invertBinaryTree(root.left);
        if(root.right!=null) invertBinaryTree(root.right);
        return root;
    }
    
    public TreeNode swap(TreeNode root, TreeNode left, TreeNode right){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
