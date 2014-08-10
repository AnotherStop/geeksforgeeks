/*
Extract Leaves of a Binary Tree in a Doubly Linked List
*/
public class ExtractLeavesFromBinaryTree{

	public void extract(TreeNode root, TreeNode[] head, TreeNode[] prev){
		if(root == null)
			return;

		extract(root.left, head, prev);

		if(root.right == null){
			if(head[0] == null)
				head[0] = root;

			if(prev[0] != null){
				prev[0].right = root;
				root.left = prev[0];
			}
			
			prev[0] = root;	
		
		}else{
			extract(root.right, head, prev);
		}

	}

	public static void main(String[] args){
		ExtractLeavesFromBinaryTree solution = new ExtractLeavesFromBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		TreeNode[] head = new TreeNode[1];
		head[0] = null;
		TreeNode[] prev = new TreeNode[1];
		prev[0] = null;
		solution.extract(root, head, prev);

		//print from left to right
		while(head[0].right != null){
			System.out.print(head[0].val + "->");
			head[0] = head[0].right;
		}
		System.out.print(head[0].val + " ");
		System.out.println();
	
		//print from right to left
		while(head[0].left != null){
			System.out.print(head[0].val + "<-");
			head[0] = head[0].left;
		}
		System.out.print(head[0].val + " ");
	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}