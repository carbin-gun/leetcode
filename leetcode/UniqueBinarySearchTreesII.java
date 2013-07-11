

import java.util.ArrayList;

import tree.TreeNode;

/**
 * Unique Binary Search Trees II
 * http://discuss.leetcode.com/questions/269/unique-binary-search-trees-ii
 */
public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> re = new ArrayList<TreeNode>();
		if (start > end) {
			re.add(null);
		} else if (start == end) {
			TreeNode node = new TreeNode(start);
			re.add(node);
		} else {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> lefts = generateTrees(start, i - 1);
				ArrayList<TreeNode> rights = generateTrees(i + 1, end);
				for (int l = 0; l < lefts.size(); l++) {
					for (int r = 0; r < rights.size(); r++) {
						TreeNode node = new TreeNode(i);
						node.left = lefts.get(l);
						node.right = rights.get(r);
						re.add(node);
					}
				}
			}
		}
		return re;
	}
	
	public static void main(String argv[]) {
		UniqueBinarySearchTreesII ub = new UniqueBinarySearchTreesII();
		ub.generateTrees(5);
	}
}
