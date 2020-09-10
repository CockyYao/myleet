package com.atsyc.dp;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LIS {


    /**
     * 求一个数组A[]的最大不下降子序列的长度
     * 设定一个动态数组，dp[]
     * dp[i] 代表以A[i]结尾的最长不下降子序列
     * 拆分： 要得到dp[i]，我们需要找到 A[i] 之前的A[j]， 满足A[j]<=A[i] && j = 1,2,3,4,...,i-1
     * if(dp[j] + 1 > dp[i] && A[i] >= A[j]){
     * dp[i] = dp[j] + 1;
     * }
     * dp[i] = max {1, dp[j] + 1} (j=1,2,3,...,i-1 && A[j] <= A[i])
     */
    public static int LIS(int[] arr) {
        int ans = -1;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && (dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,-1,-2,7,9,8,9,9};
        System.out.println(LIS(a));
    }

}
