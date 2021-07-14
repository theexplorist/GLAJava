package class8;

import java.util.Arrays;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
		int maxNum = Integer.MIN_VALUE;

		for (int el : nums) {
			maxNum = Math.max(maxNum, el);
		}

		int[] ha = new int[maxNum + 1];
		for (int el : nums) {
			ha[el] += el;
		}

		int[] dp = new int[ha.length + 1];
		Arrays.fill(dp, -1);
		return rob(ha, 0, ha.length, dp);
	}

	public int rob(int[] nums, int curr, int n, int[] dp) {

		if (curr >= n) {
			return 0;
		}

		if (dp[curr] != -1) {
			return dp[curr];
		}

		int c1 = rob(nums, curr + 1, n, dp);
		int c2 = nums[curr] + rob(nums, curr + 2, n, dp);

		return dp[curr] = Math.max(c1, c2);
	}

}
