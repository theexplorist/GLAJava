package class24;

import class24.AddInBST.TreeNode;

public class DeleteInBST {

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

	private int min(TreeNode root) {
		// TODO Auto-generated method stub

		if (root.left == null) {
			return root.val;
		}
		return min(root.left);
	}

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else { // key == root.val
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else {
				int minVInRight = min(root.right);// 11
				root.val = minVInRight;
				root.right = deleteNode(root.right, minVInRight);
			}
		}

		return root;
	}

}
