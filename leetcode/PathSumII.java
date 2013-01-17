import java.util.ArrayList;

/**
 * Path Sum II some times one little thing can change the run time.
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 * 
 * http://discuss.leetcode.com/questions/279/path-sum-ii
 * 
 */

/*
 * The solution will base on what kind of array the result want, root to leave or
 * leave to root;
 */
public class PathSumII {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		pathSumII(result, tmp, root, sum);
		return result;
	}

	public void pathSumII(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> tmp, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		tmp.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			result.add((ArrayList<Integer>) tmp.clone());
		} else {
			pathSumII(result, tmp, root.left, sum - root.val);
			pathSumII(result, tmp, root.right, sum - root.val);
		}
		tmp.remove(tmp.size() - 1);
	}

	public ArrayList<ArrayList<Integer>> pathSumNoneLarge(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return cur;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> s = new ArrayList<Integer>();
			s.add(sum);
			cur.add(s);
		} else {
			cur.addAll(pathSum(root.left, sum - root.val));
			cur.addAll(pathSum(root.right, sum - root.val));
			for (ArrayList<Integer> t : cur) {
				t.add(0, root.val); // in case of this line can not pass the
									// large
			}
		}
		return cur;
	}
}
