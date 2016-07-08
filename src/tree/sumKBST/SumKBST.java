package tree.sumKBST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumKBST {
	
	public static List<Integer> getPairForKsum(TreeNode root, int k){
		if(root==null)	return null;
		TreeNode n1 = root;
		TreeNode n2 = root;
		boolean leftDone = false;
		boolean rightDone = false;
		int val1 = 0, val2=0;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<Integer> pair = new ArrayList<>();
		
		while(true){
			// Go in-order on the left side
			while(!leftDone){
				if(n1!=null){
					s1.push(n1);
					n1 = n1.left;
				}
				else{
					if(s1.isEmpty())
						leftDone = true;
					else{
						n1  = s1.pop();
						val1 = n1.value;
						n1 = n1.right;
						leftDone = true;
					}
				}
			}
			
			// Go reverse in-order on the right side
			while(!rightDone){
				if(n2!=null){
					s2.push(n2);
					n2 = n2.right;
				}
				else{
					if(s2.isEmpty())
						rightDone = true;
					else{
						n2  = s2.pop();
						val2 = n2.value;
						n2 = n2.left;
						rightDone = true;
					}
				}
			}			
			
			if(val1!=val2 && (val1+val2==k)){				
				pair.add(val1);
				pair.add(val2);		
				return pair;
			}
			else if(val1+val2 < k)
				leftDone = false;
			else if(val1+val2 > k)
				rightDone = false;
			
			if(val1 > val2)
				return pair;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
