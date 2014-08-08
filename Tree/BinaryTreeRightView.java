/*
Given a Binary Tree, print Right view of it. 
Right view of a Binary Tree is set of nodes visible when tree is visited from Right side.
*/
import java.util.*;
public class BinaryTreeRightView{

	public void rightView(TreeNode root, int currentLevel, int[] maxLevel){
		if(root == null)
			return;

		if(currentLevel > maxLevel[0]){
			System.out.print(root.val + " ");
			maxLevel[0] += 1;
		}

		rightView(root.right, currentLevel+1, maxLevel);
		rightView(root.left, currentLevel+1, maxLevel);
	}

	public static void main(String[] args){
		BinaryTreeRightView solution = new BinaryTreeRightView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
    	//root.right.right.right = new TreeNode(9);

		solution.rightView(root, 1, new int[1]);

	}
		
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}