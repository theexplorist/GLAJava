package class20;

public class DiameterOne {

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

	class Pair {
		int height;
		int diameter;

		public Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	public int diameterOfBinaryTree(TreeNode root) {

		Pair ansPair = diameterOfBinaryTreee(root);
		return ansPair.diameter;
	}

	public Pair diameterOfBinaryTreee(TreeNode root) {

		if (root == null) {
			return new Pair(0, 0);
		}

		Pair leftPair = diameterOfBinaryTreee(root.left);// 6
		Pair rightPair = diameterOfBinaryTreee(root.right);// 0

		int apniHeight = Math.max(leftPair.height, rightPair.height) + 1;
		int apnaDia = leftPair.height + rightPair.height;

		int maxDia = Math.max(apnaDia, Math.max(leftPair.diameter, rightPair.diameter));

		return new Pair(apniHeight, maxDia);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
