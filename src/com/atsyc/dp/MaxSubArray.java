package com.atsyc.dp;

/**
 *
 * https://leetcode-cn.com/problems/maximum-subarray/solution/53-zui-da-zi-xu-he-java-dong-tai-gui-hua-by-flagma/
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    // [a,b,c,d,e]
    // 以a结尾 [a]
    // 以b结尾 [a],[a,b]
    // 以c结尾 [a,b,c],[b,c],[c]
    // 以d结尾 [a,b,c,d],[b,c,d],[c,d],[d]
    // 以e结尾 [a,b,c,d,e],[b,c,d,e],[c,d,e],[d,e],[e]

    /*
    *  f(i)表示以num[i]结尾的最大子数组和
    *  f(i+1) = max{num[i+1], f(i) + num[i]}
    *
    * */

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = ans;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }


    /**
     *
     * https://leetcode-cn.com/problems/continuous-subarray-sum/
     * @param nums
     * @param k
     * @return
     */
    // [a,b,c,d,e]
    // 以a结尾 [a]
    // 以b结尾 [a],[a,b]
    // 以c结尾 [a,b,c],[b,c],[c]
    // 以d结尾 [a,b,c,d],[b,c,d],[c,d],[d]
    // 以e结尾 [a,b,c,d,e],[b,c,d,e],[c,d,e],[d,e],[e]
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum = sum + nums[j];
                if(j != i){
                    if (k == 0 && sum == 0) {
                        return true;
                    }
                    if (k != 0 && sum % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
