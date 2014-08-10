/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
*/
public class BinaryTreeToDoubleLinkedList{

	public void convert(TreeNode root, TreeNode[] head, TreeNode[] prev){
		if(root == null)
			return;

		if(root.left != null)
			convert(root.left, head, prev);

		if(head[0] == null)
			head[0] = root;

		if(prev[0] != null){
			prev[0].right = root;
			root.left = prev[0];
		}

		prev[0] = root;

		if(root.right != null)
			convert(root.right, head, prev);

	}

	public static void main(String[] args){
		BinaryTreeToDoubleLinkedList solution = new BinaryTreeToDoubleLinkedList();
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
		solution.convert(root, head, prev);

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