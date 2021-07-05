package class1;

public class PrintReverse {

	private static void reverse(int[]arr, int n, int ci) {
		// TODO Auto-generated method stub

		if(ci == n) {
			return;
		}
		reverse(arr, n, ci + 1);
		System.out.println(arr[ci]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 3, 4, 5};
		int n = 5;
		reverse(arr, n, 0);
	}

}
