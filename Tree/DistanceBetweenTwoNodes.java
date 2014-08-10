/*
Find the distance between two keys in a binary tree, no parent pointers are given. 
Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
*/
public class DistanceBetweenTwoNodes{
	public int findDistance(TreeNode root, TreeNode n1, TreeNode n2){
		//depth of node to root's child
		int left1 = getDepth(root.left, n1);
		int right1 = getDepth(root.right, n2);
		int left2 = getDepth(root.left, n2);
		int right2 = getDepth(root.right, n1);

		//since depth is to root's child,so we should +1
		if(root == n1)
			return right1 == -1 ? left2+1 : right1+1;
		if(root == n2)
			return left1 == -1 ? right2+1 : left1+1;

		if(left1 == -1 && left2 == -1)
			return findDistance(root.right, n1, n2);
		if(right1 == -1 && right2 == -1)
			return findDistance(root.left,n1, n2);

		//since depth is to root's child,so we should +1 for each side
		if(left1 != -1 && right1 != -1)
			return left1 + right1 + 2;
		else
			return left2 + right2 + 2;
	}

	//get the depth of target node
	public int getDepth(TreeNode root, TreeNode target){
		if(root == target)
			return 0;

		if(root == null)
			return -1;

		int leftResult = getDepth(root.left, target);
		if(leftResult != -1)
			return leftResult+1;

		int rightResult = getDepth(root.right, target);
		rightResult = (rightResult == -1) ? -1 : rightResult+1;
		return rightResult;
	}

	public static void main(String[] args){
		DistanceBetweenTwoNodes solution = new DistanceBetweenTwoNodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		int testCase1 = solution.findDistance(root, root.left.left, root.left.right);
		int testCase2 = solution.findDistance(root, root.left.left, root.right.left);
		int testCase3 = solution.findDistance(root, root.right, root.left.left);
		int testCase4 = solution.findDistance(root, root.left, root.left.left);
		int testCase5 = solution.findDistance(root, root.right.left.right, root.left.right);
		System.out.println("Test Case 1: " + testCase1);
		System.out.println("Test Case 2: " + testCase2);
		System.out.println("Test Case 3: " + testCase3);
		System.out.println("Test Case 4: " + testCase4);
		System.out.println("Test Case 5: " + testCase5);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}