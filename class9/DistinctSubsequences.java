package class9;

import java.util.Arrays;

public class DistinctSubsequences {

	private static int sol(String source, String target, int n, int m, int[][] dp) {
		// TODO Auto-generated method stub
		//target string ban gyi
		if(m == 0) {
			return 1; //1 tareeka
		}
		
		//target ni bani/ source khatam yaani aisi country jisme currency hi ni hai
		if(n == 0) {
			return 0;
		}
		
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		int inc = 0, exc = 0;
		
		if(source.charAt(n - 1) == target.charAt(m - 1)) {
			inc = sol(source, target, n - 1, m - 1,  dp);
		}

		exc = sol(source, target, n - 1, m, dp);
		
		return dp[n][m] = inc + exc;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String source = "babgbag";
		String target = "bag";
		
		int n = source.length();
		int m = target.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		
		System.out.println(sol(source, target, n, m, dp));
	}

}
