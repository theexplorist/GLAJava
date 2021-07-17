package class10;

public class UncrossedLines {

	private static int sol(int[] s1, int[] s2, int n, int m) {
		// TODO Auto-generated method stub

		if(n == 0 || m == 0) {
			return 0;
		}
		if(s1[n - 1] == s2[m - 1]) {
			return 1 + sol(s1, s2, n - 1, m - 1);
		}
		
		int c1 = sol(s1, s2, n - 1, m);
		int c2 = sol(s1, s2, n, m - 1);
		
		return Math.max(c1, c2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s1 = {1, 4, 2};
		int[] s2 = {1, 2, 4};
		
		System.out.println(sol(s1, s2, s1.length, s2.length));
	}

}
