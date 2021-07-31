package class20;

public class DiameterTwo {

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

	public int diameterOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int currNodeLeftHeight = height(root.left);
		int currNodeRightHeight = height(root.right);

		int currPath = currNodeLeftHeight + currNodeRightHeight;// 5

		int leftPath = diameterOfBinaryTree(root.left);// 6
		int rightPath = diameterOfBinaryTree(root.right);// 0

		return Math.max(currPath, Math.max(leftPath, rightPath));
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
