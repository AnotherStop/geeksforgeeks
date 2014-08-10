/*
Remove all nodes which don’t lie in any path with sum>= k
*/
import java.util.*;
public class RemoveNodesFromPath{

	public boolean remove(TreeNode root, int k, int sum){
		if(root.left == null && root.right == null){
			if(sum + root.val >= k)
				return false;
			else
				return true;
		}

		boolean removeLeft = true;
		boolean removeResult = true;
		if(root.left != null){
			removeLeft = remove(root.left, k, sum+root.val);
			if(removeLeft == true)
				root.left = null;
		}

		if(root.right != null){
			removeResult = remove(root.right, k ,sum+root.val);
			if(removeResult == true)
				root.right = null;
		}

		return removeLeft && removeResult;
	}

	public void levelOrderPrint(TreeNode root){
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);

		while(q1.isEmpty() == false){
			TreeNode current = q1.poll();
			if(current.left != null)
				q2.add(current.left);
			if(current.right != null)
				q2.add(current.right);

			System.out.print(current.val + " ");

			if(q1.isEmpty() == true){
				Queue<TreeNode> temp = q1;
				q1 = q2;
				q2 = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args){
		RemoveNodesFromPath solution = new RemoveNodesFromPath();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.left.left.left = new TreeNode(8);
	    root.left.left.right = new TreeNode(9);
	    root.left.right.left = new TreeNode(12);
	    root.right.right.left = new TreeNode(10);
	    root.right.right.left.right = new TreeNode(11);
	    root.left.left.right.left = new TreeNode(13);
	    root.left.left.right.right = new TreeNode(14);
	    root.left.left.right.right.left = new TreeNode(15);

	    solution.levelOrderPrint(root);

	    int k = 45;
		solution.remove(root, k, 0);

		solution.levelOrderPrint(root);
	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}