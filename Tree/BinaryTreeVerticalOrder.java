/* Given a binary tree, print it vertically.
  
If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. 
HD for root is 0, a right edge (edge connecting to right subtree) is
considered as +1 horizontal distance and a left edge is considered as -1
horizontal distance. 
*/

import java.util.*;
public class BinaryTreeVerticalOrder{

	HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();

	public void verticalOrder(TreeNode root, int distance){
		if(root == null)
			return;

		if(hm.containsKey(distance))
			hm.get(distance).add(root.val);
		else{
			LinkedList<Integer> temp = new LinkedList<Integer>();
			temp.add(root.val);
			hm.put(distance, temp);
		}

		verticalOrder(root.left, distance-1);
		verticalOrder(root.right, distance+1);	
	}


	public static void main(String[] args){
		BinaryTreeVerticalOrder solution = new BinaryTreeVerticalOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
    	root.right.right.right = new TreeNode(9);

		solution.verticalOrder(root, 0);
		
		SortedSet<Integer> keys = new TreeSet<Integer>(solution.hm.keySet());

		for(int i : keys){
			System.out.println(solution.hm.get(i));
		}

	}
		
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}