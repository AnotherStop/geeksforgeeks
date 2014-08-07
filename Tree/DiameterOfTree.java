public class DiameterOfTree{
	public int[] getDiameter(TreeNode root){
		int[] result = new int[2]; //result[0] for diameter, result[1] for height

		if(root == null)
			return result;

		int[] leftResult = getDiameter(root.left);
		int[] rightResult = getDiameter(root.right);

		int height = Math.max(leftResult[1], rightResult[1]) + 1;
		int crossRootDiameter = leftResult[1] + 1 + rightResult[1];
		result[0] = Math.max(crossRootDiameter, Math.max(leftResult[0], rightResult[0]));
		result[1] = height;

		return result;
	}

	public static void main(String[] args){
		DiameterOfTree solution = new DiameterOfTree();
		TreeNode root = new TreeNode(5);
		TreeNode leftChild = new TreeNode(3);
		root.left = leftChild;
		leftChild.right = new TreeNode(1);

		TreeNode rightChild = new TreeNode(9);
		root.right = rightChild;

		int[] result = solution.getDiameter(root);
		System.out.println("The diameter is: " + result[0]);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}