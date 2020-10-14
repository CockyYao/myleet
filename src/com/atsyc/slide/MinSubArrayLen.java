package com.atsyc.slide;

/**
 *
 * https://lucifer.ren/blog/2020/03/16/slide-window/
 *
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        boolean exist = false;

        while (r < nums.length) {
            if (sum(l, r, nums) < s) {
                r++;
            } else {
                exist = true;
                while (l < nums.length && l <= r) {
                    if (sum(l, r, nums) >= s) {
                        len = Math.min(r - l + 1, len);
                        l++;
                    } else {
                        break;
                    }
                }

            }
        }
        return exist ? len : 0;
    }

    private int sum(int l, int r, int[] nums) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
        }
        return sum;
    }


}
