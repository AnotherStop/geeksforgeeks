/*
 Given a BST, transform it into greater sum tree 
 where each node contains sum of all nodes greater than that node.
 like	4          5
 	   / \   to   / \
 	  3   5      9   0

 */
import java.util.*;
public class BSTToGreaterSumTree{
	public void convert(TreeNode root){
		int result = 0;
		Stack<TreeNode> st = new Stack<TreeNode>();
		
		while(root != null || st.isEmpty() == false){
			if(root!= null){
				st.push(root);
				root = root.right;
			}else{
				root = st.pop();
				int temp = root.val;
				root.val = result;
				result += temp;
				root = root.left;
			}
		}

	}

	public void inorderTraversal(TreeNode root){
		if(root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args){
		BSTToGreaterSumTree solution = new BSTToGreaterSumTree();
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(2);
		root.right = new TreeNode(29);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(40);
		root.right.right.left = new TreeNode(35);

		solution.inorderTraversal(root);
		System.out.println();
		solution.convert(root);
		solution.inorderTraversal(root);
		System.out.println();

	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}