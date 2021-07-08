package class2;

public class AllIndices {

	public static int[] sol(int[] arr, int ci, int n, int search, int count) {
		
		if(ci == n) {
			int[] bca = new int[count];
			return bca;
		}
		
		if(arr[ci] == search) {
			int[] ra = sol(arr, ci + 1, n, search, count + 1);
			ra[count] = ci;
			return ra;
		} else {
			int[] ra = sol(arr, ci + 1, n, search, count);
			return ra;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 4, 2, 6 };
		int n = 5;
		int[] ans = sol(arr, 0, n, 7, 0);
		if(ans.length == 0) {
			System.out.println(-1);
			return;
		}
		for(int index : ans) {
			System.out.print(index + " ");
		}
	}

}
