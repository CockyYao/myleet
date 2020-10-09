package com.atsyc.dp;

/**
 * Created by doubleyao on 2020-10-09.
 */
public class Rob {


    /**
     * version 1
     * dp[n] = max{dp[n-1],dp[n-2]+nums[n]}
     * <p>
     * if nums[n-1] is not robbed
     * then dp[n-1]=dp[n-2]
     * <p>
     * if nums[n-1] is robbed
     * then dp[n-1] + nums[n] is not allowed
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /**
     * version 2
     * dp[0] = nums[0]
     * dp[1] = max{nums[0],nums[1]}
     * dp[n] = max{dp[n-1],dp[n-2]+nums[n]}
     * <p>
     * 环状链表:    首尾 不能同时去抢
     */
    public int robHelp(int[] nums, int l, int r) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i < r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[r - 1];
    }


    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelp(nums, 0, nums.length - 1), robHelp(nums, 1, nums.length));
    }

}
