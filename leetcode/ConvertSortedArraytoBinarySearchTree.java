/**
 * Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * http://discuss.leetcode.com/questions/109/convert-sorted-array-to-binary-search-tree
 */

/*
 * A recursive method can easy solve this question. 
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length == 0) {
			return null;
		}
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] num, int s, int e) {
		int mid = s + (e - s) / 2;
		TreeNode root = new TreeNode(num[mid]);
		if (mid > s) {
			root.left = sortedArrayToBST(num, s, mid - 1);
		}
		if (mid < e) {
			root.right = sortedArrayToBST(num, mid + 1, e);
		}
		return root;
	}
}
