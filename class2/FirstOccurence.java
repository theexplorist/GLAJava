package class2;

public class FirstOccurence {

	private static int sol(int[] arr, int ci, int search, int n) {
		// TODO Auto-generated method stub

		if (ci == n) {
			return -1;
		}
		if (arr[ci] == search) {
			return ci;
		}

		int recAns = sol(arr, ci + 1, search, n);
		return recAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 4, 2, 6 };
		int n = 5;

		System.out.println(sol(arr, 0, 7, n));
	}

}
