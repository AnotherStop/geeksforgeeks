/*
Given a Binary Tree and a positive integer k, 
print all nodes that are distance k from a leaf node.
*/
import java.util.*;
public class PrintDistanceKFromLeafNode{

	static HashSet<Integer> hs = new HashSet<>();	//store depth, nodes in that depth is we want

	public void printKDistance(TreeNode root,int depth, int k)
	{
		if(root==null) 
			return;

		//if we reach leaf node
		if(root.left==null && root.right==null && depth>k){
			hs.add(depth-k);	//node with height of depth-k is what we want
			return;
		}

		printKDistance(root.left,depth+1,k);
		printKDistance(root.right,depth+1,k);
		
		//depth at here is equal to the value of depth-k that we get at leaf node
		//node of current depth should be output if it's in hash set
		if(hs.contains(depth)){
			System.out.println(root.val);
			hs.remove(depth);
		}
	}

	public static void main(String[] args){
		PrintDistanceKFromLeafNode solution = new PrintDistanceKFromLeafNode();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
    	root.right.right.right = new TreeNode(9);

		solution.printKDistance(root, 1, 2);

	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}