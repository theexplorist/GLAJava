package class24;

public class ValidateBST {

	// Definition for a binary tree node.
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode() {
			}

			TreeNode(int val) {
				this.val = val;
			}

			TreeNode(int val, TreeNode left, TreeNode right) {
				this.val = val;
				this.left = left;
				this.right = right;
			}
		}
	public boolean isValidBST(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isBST(TreeNode root, long minRange, long maxRange) {

		if (root == null) {
			return true;
		}

		if (root.val <= minRange || root.val >= maxRange) {
			return false;
		}
		boolean left = isBST(root.left, minRange, root.val);
		boolean right = isBST(root.right, root.val, maxRange);
		return left && right;
	}
}
