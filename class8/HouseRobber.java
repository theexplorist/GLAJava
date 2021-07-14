package class8;

import java.util.Arrays;

public class HouseRobber {

	public int rob(int[] nums) {
		int[] dp = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		return maxMoney(nums, 0, nums.length, dp);
	}

	public static int maxMoney(int[] house, int curr, int n, int[] dp) {

		if (curr >= n) {
			return 0;
		}

		if (dp[curr] != -1) {
			return dp[curr];
		}
		int c1 = house[curr] + maxMoney(house, curr + 2, n, dp);
		int c2 = maxMoney(house, curr + 1, n, dp);

		return dp[curr] = Math.max(c1, c2);
	}

}
