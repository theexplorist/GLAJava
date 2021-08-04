package class23;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] in = {10, 20, 30, 40, 50, 60, 70};
		
		BinarySearchTree bst = new BinarySearchTree(in);
		bst.display();
		bst.replaceWithLarger();
		System.out.println("_--------------------------");
		
		
		bst.display();
		//System.out.println(bst.max());
		//System.out.println(bst.find(45));
	}

}
