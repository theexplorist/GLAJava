package class18;

import java.util.Scanner;

public class BinaryTree {
//3 true 6 true 7 false false true 8 false false true 5 false false
	private Scanner sc = new Scanner(System.in);

	private class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = this.construct(null, true);// 3k
	}

	// ilc -> true (left child)
	// ilc -> false (right child)
	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node!");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.val);
			} else {
				System.out.println("Enter the data for right child of " + parent.val);
			}
		}

		int data = sc.nextInt();

		Node node = new Node();
		node.val = data;

		System.out.println("Kya " + node.val + " ka left child hai?"); // 3
		boolean kyaLeftHai = sc.nextBoolean(); // true

		if (kyaLeftHai)
			node.left = construct(node, true);

		System.out.println("Kya " + node.val + " ka right child hai?"); // 3
		boolean kyaRightHai = sc.nextBoolean(); // true

		if (kyaRightHai)
			node.right = construct(node, false);

		return node; // 3k
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

	public int height() {

		return this.height(this.root);
	}

	private int height(Node root) {

		if (root == null) {

			return 0;
		}
		int leftSubTreeKiHeight = height(root.left);
		int rightSubTreeKiHeight = height(root.right);

		int max = Math.max(leftSubTreeKiHeight, rightSubTreeKiHeight);

		return max + 1;
	}

	public int max() {

		return this.max(this.root);
	}

	private int max(Node root) {

		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int leftMax = max(root.left);
		int rightMax = max(root.right);
		
		return Math.max(root.val, Math.max(leftMax, rightMax));
	}
}
