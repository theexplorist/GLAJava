package class22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

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

		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int leftMax = max(root.left);
		int rightMax = max(root.right);

		return Math.max(root.val, Math.max(leftMax, rightMax));
	}

	public void preOrder() {
		// TODO Auto-generated method stub

		this.preOrder(this.root);
	}

	private void preOrder(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder() {
		// TODO Auto-generated method stub

		this.inOrder(this.root);
	}

	private void inOrder(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	public void postOrder() {
		// TODO Auto-generated method stub

		this.postOrder(this.root);
	}

	private void postOrder(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		postOrder(root.left);

		postOrder(root.right);
		System.out.println(root.val);
	}

	public void verticalTraversal() {

		this.verticalTraversal(this.root);
	}

	class Pair {
		int stickLvl;
		Node node;

		public Pair(int stickLvl, Node node) {
			this.stickLvl = stickLvl;
			this.node = node;
		}
	}

	private void verticalTraversal(Node root) {

		Queue<Pair> bfs = new LinkedList<>();

		bfs.add(new Pair(0, root));

		Map<Integer, List<Integer>> map = new TreeMap<>();

		while (!bfs.isEmpty()) {

			Pair front = bfs.poll();

			int stickLvl = front.stickLvl;
			Node curr = front.node;

			List<Integer> value = map.getOrDefault(stickLvl, new ArrayList<>());
			value.add(curr.val);

			map.put(stickLvl, value);

			if (curr.left != null) {
				bfs.add(new Pair(stickLvl - 1, curr.left));
			}

			if (curr.right != null) {
				bfs.add(new Pair(stickLvl + 1, curr.right));
			}
		}

		System.out.println(map.values());

	}

	public void verticalTraversalTop() {

		this.verticalTraversalTop(this.root);
	}

	private void verticalTraversalTop(Node root) {

		Queue<Pair> bfs = new LinkedList<>();

		bfs.add(new Pair(0, root));

		Map<Integer, List<Integer>> map = new TreeMap<>();

		while (!bfs.isEmpty()) {

			Pair front = bfs.poll();

			int stickLvl = front.stickLvl;
			Node curr = front.node;

			List<Integer> value = map.getOrDefault(stickLvl, new ArrayList<>());
			value.add(curr.val);

			map.put(stickLvl, value);

			if (curr.left != null) {
				bfs.add(new Pair(stickLvl - 1, curr.left));
			}

			if (curr.right != null) {
				bfs.add(new Pair(stickLvl + 1, curr.right));
			}
		}

		for (List<Integer> lvl : map.values()) {
			System.out.println(lvl.get(lvl.size() - 1));// case bottom ka -> lvl.size() - 1
		}

	}

}
