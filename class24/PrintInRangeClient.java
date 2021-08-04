package class24;

public class PrintInRangeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 20, 30, 40, 50, 60, 70};
		BinarySearchTree bst = new BinarySearchTree(arr);
		
		bst.printInRange(25, 55);//inclusive
	}

}
