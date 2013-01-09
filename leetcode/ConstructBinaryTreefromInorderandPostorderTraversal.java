/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * http://discuss.leetcode.com/questions/186/construct-binary-tree-from-inorder-
 * and-postorder-traversal
 */

/*
 * The solution is using the recursive to build up the tree. The last item of
 * postorder can separate inorder to left and right. The left and right can
 * easily be separated in the postorder by the number of items in left and
 * right, which we already know by separating of inorder.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length == 0 || inorder.length != postorder.length) {
			return null;
		} else {
			return buildTree(inorder, postorder, 0, inorder.length - 1, 0,
					postorder.length - 1);
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder, int s1, int e1,
			int s2, int e2) {
		TreeNode root = new TreeNode(postorder[e2]);
		int sep = s1;
		while (inorder[sep] != root.val) {
			sep++;
		}
		if (sep > s1) {
			root.left = buildTree(inorder, postorder, s1, sep - 1, s2, s2 + sep
					- 1 - s1);
		}
		if (sep < e1) {
			root.right = buildTree(inorder, postorder, sep + 1, e1, e2 - e1
					+ sep, e2 - 1);
		}
		return root;
	}
}
