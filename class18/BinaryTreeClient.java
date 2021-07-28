package class18;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bt = new BinaryTree();
		bt.display();
		int height = bt.height();
		System.out.println(height);
		
		int maxValue = bt.max();
		System.out.println(maxValue);
	}

}
