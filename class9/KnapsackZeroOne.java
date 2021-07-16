package class9;

import java.util.Arrays;

public class KnapsackZeroOne {

	private static int sol(int[] weight, int[] cost, int n, int bagC, int[][] dp) {
		// TODO Auto-generated method stub
		if(bagC == 0 || n == 0) {
			return 0;
		}
		
		if(dp[n][bagC] != -1) {
			return dp[n][bagC];
		}
		int inc = 0, exc = 0;
		
		if(weight[n - 1] <= bagC) {
			inc = cost[n - 1] + sol(weight, cost, n - 1, bagC - weight[n - 1], dp);
		}

		exc = sol(weight, cost, n - 1, bagC, dp);
		
		return dp[n][bagC] =  Math.max(inc, exc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] weight = {1, 2, 3, 2, 2};
		int[] cost = {8, 4, 0, 5, 3};
		
		int n = 5;
		int bagC = 4;
		int[][] dp = new int[n + 1][bagC + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(sol(weight, cost, n, bagC, dp));
	}

}
