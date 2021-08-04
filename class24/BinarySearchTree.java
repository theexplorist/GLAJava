package class24;

public class BinarySearchTree {

	private class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int l, int r) {
		// TODO Auto-generated method stub

		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;
		Node node = new Node();
		node.val = in[mid];

		node.left = construct(in, l, mid - 1); // left sub tree

		node.right = construct(in, mid + 1, r); // right sub tree

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += '_';
		} else {
			str += node.left.val;
		}

		str += " -> " + node.val + " <- ";

		if (node.right == null) {
			str += '_';
		} else {
			str += node.right.val;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node root) {
		// TODO Auto-generated method stub

		if (root.right == null) {
			return root.val;
		}
		return max(root.right);
	}

	public boolean find(int target) {
		return this.find(this.root, target);
	}

	private boolean find(Node root, int target) {
		// TODO Auto-generated method stub

		if (root == null) {
			return false;
		}
		if (root.val > target) {
			return find(root.left, target);
		} else if (root.val < target) {
			return find(root.right, target);
		} else {
			return true;
		}
	}

	int sum = 0;

	public void replaceWithLarger() {
		// TODO Auto-generated method stub

		replaceWithLarger(this.root);
	}

	private void replaceWithLarger(Node root) {
		if (root == null) {
			return;
		}
		// right self left

		replaceWithLarger(root.right);

		int temp = root.val;
		root.val = sum;
		sum = sum + temp;

		replaceWithLarger(root.left);
	}

	public void printInRange(int low, int high) {
		// TODO Auto-generated method stub

		this.printInRange(this.root, low, high);
	}

	private void printInRange(Node root, int low, int high) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}
		if (root.val < low) {
			printInRange(root.right, low, high);
		} else if (root.val > high) {
			printInRange(root.left, low, high);
		} else {// inside range

			printInRange(root.left, low, high);
			System.out.println(root.val);
			printInRange(root.right, low, high);
		}
	}

}
