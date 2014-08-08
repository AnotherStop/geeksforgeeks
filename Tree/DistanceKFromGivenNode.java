/*
Given a binary tree, a target node in the binary tree, and an integer value k, 
print all the nodes that are at distance k from the given target node. 

Distance can be upward or downward. No parent pointers are available.
*/
import java.util.*;
public class DistanceKFromGivenNode{

	//print node that K down from root
	public void printTopDown(TreeNode root, int K){
		if(root == null)
			return;

		if(K == 0){
			System.out.println(root.val);
			return;
		}

		printTopDown(root.left, K-1);
		printTopDown(root.right, K-1);
	}

	//return value is the distance of root to target
	//or -1, that target no in this subtree
	public int findTarget(TreeNode root, TreeNode target, int K){
		if(root == null)
			return -1;

		if(root == target){
			printTopDown(root, K);
			return 1;
		}

		//first test whether target in left subtree
		int leftResult = findTarget(root.left, target, K);
		if(leftResult != -1){
			if(leftResult == K)
				System.out.println(root.val);

			printTopDown(root.right, K-leftResult-1);	//take care distance
			return leftResult + 1;
		}

		//if not in left subtree, test in right subtree
		int rightResult = findTarget(root.right, target, K);
		if(rightResult != -1){
			if(rightResult == K)
				System.out.println(root.val);

			printTopDown(root.left, K-rightResult-1);	//take care distance
			return rightResult+1;
		}

		return -1;
	}

	public static void main(String[] args){
		DistanceKFromGivenNode solution = new DistanceKFromGivenNode();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
    	root.right.right.right = new TreeNode(9);

		solution.findTarget(root, root.right.left, 3);

	}
		
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}