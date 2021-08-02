package class21;

public class BalancedBTBottomUp {

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
		boolean isBalanced;

		public Pair(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	public Pair isBalance(TreeNode root) {

		if (root == null) {
			return new Pair(0, true);
		}

		Pair left = isBalance(root.left);
		Pair right = isBalance(root.right);

		int apnaDiff = Math.abs(left.height - right.height);
		int apniHeight = Math.max(left.height, right.height) + 1;

		boolean kyaBalancedHai = apnaDiff <= 1 && left.isBalanced && right.isBalanced;
		return new Pair(apniHeight, kyaBalancedHai);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
