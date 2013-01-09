/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */

/*
 * Quit same with the post and in order construct BT
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length == 0 || inorder.length != preorder.length) {
			return null;
		} else {
			return buildTree(preorder, inorder, 0, inorder.length - 1, 0,
					preorder.length - 1);
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1,
			int s2, int e2) {
		TreeNode root = new TreeNode(preorder[s1]);
		int sep = s2;
		while (sep <= e2 && inorder[sep] != root.val) {
			sep++;
		}
		if (sep > s2) {
			root.left = buildTree(preorder, inorder, s1 + 1, s1 + sep - s2, s2,
					sep - 1);
		}
		if (sep < e2) {
			root.right = buildTree(preorder, inorder, s1 + sep - s2 + 1, e1,
					sep + 1, e2);
		}
		return root;
	}
}
