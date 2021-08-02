package class21;

public class BalancedBinaryTree {

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

	private int height(TreeNode root) {

		if (root == null) {

			return 0;
		}
		int leftSubTreeKiHeight = height(root.left);
		int rightSubTreeKiHeight = height(root.right);

		int max = Math.max(leftSubTreeKiHeight, rightSubTreeKiHeight);

		return max + 1;
	}

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		int diff = Math.abs(leftHeight - rightHeight);

//		if(diff <= 1) {
//			boolean left = isBalanced(root.left);
//			boolean right = isBalanced(root.right);
//			
//			return left && right;
//		} else {
//			return false;
//		}

		return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
