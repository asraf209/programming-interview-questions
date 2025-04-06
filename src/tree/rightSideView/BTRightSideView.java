package tree.rightSideView;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTRightSideView {

	public static void binaryTreeRightSideView(TreeNode root){
		if(root == null)	return;
		Queue<TreeNode> currentLevel = new LinkedList<>();

		currentLevel.offer(root);
        while (true) {
            if (!currentLevel.isEmpty()) {
                System.out.println(currentLevel.peek().value);
            }

			Queue<TreeNode> nextLevel = new LinkedList<>();
			while (!currentLevel.isEmpty()) {
                TreeNode n = currentLevel.poll();
                if (n.right != null) nextLevel.offer(n.right);
				if (n.left != null) nextLevel.offer(n.left);
            }

			if (nextLevel.isEmpty())	break;
			currentLevel = nextLevel;
        }
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		n3.right = n4;

		binaryTreeRightSideView(n1);
		System.out.println();

		n1 = new TreeNode(1);
		n2 = new TreeNode(2);
		n3 = new TreeNode(3);
		n4 = new TreeNode(4);
		n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n4.left = n5;

		binaryTreeRightSideView(n1);
	}

}
