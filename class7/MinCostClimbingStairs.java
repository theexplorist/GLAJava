package class7;

import java.util.Arrays;

public class MinCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		int s1 = helper(cost, 0, n, dp);
		int s2 = helper(cost, 1, n, dp);
		return Math.min(s1, s2);
	}

	public static int helper(int[] cost, int curr, int n, int[] dp) {

		if (curr >= n) {
			return 0;
		}

		if (curr == n - 1) {
			return cost[n - 1];
		}

		if (dp[curr] != -1) {
			return dp[curr];
		}

		int c1 = helper(cost, curr + 1, n, dp);
		int c2 = helper(cost, curr + 2, n, dp);

		int futureMin = Math.min(c1, c2);
		int mera = cost[curr] + futureMin;
		return dp[curr] = mera;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] cost = {10,15,20};
		System.out.println(minCostClimbingStairs(cost));
		
	}

}
