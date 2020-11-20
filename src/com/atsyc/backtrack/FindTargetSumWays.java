package com.atsyc.backtrack;

/**
 * Created by doubleyao on 2020-11-21.
 *
 * https://leetcode-cn.com/problems/target-sum/
 *
 * 自己的思考:
 *
 * res = s- nums[i]
 *
 * res = s + nums[i]
 *
 *
 *
 */
public class FindTargetSumWays {


    // dp
    public int findTargetSumWays(int[] nums, int S) {

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            help(nums, i, S - nums[i]);
        }
        return 0;
    }

    private int help(int[] nums, int startIndex, int target) {
        return 0;
    }

}
