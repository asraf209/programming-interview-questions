package tree.sumKBST;

import java.util.List;
import java.util.Stack;

public class SumKBST {
	
	public static List<Integer> getPairForKsum(TreeNode root, int k){
		if(root==null)	return null;
		TreeNode n1 = root;
		TreeNode n2 = root;
		boolean leftDone = false;
		boolean rightDone = false;
		int val1, val2;
		Stack<Integer> s1 = new Stack<>();
		
		while(true){
			// Go in-order on the left side
			while(!leftDone){
				if(n1!=null){
					s1.push(n1.value);
					n1 = n1.left;
				}
				else{
					
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
