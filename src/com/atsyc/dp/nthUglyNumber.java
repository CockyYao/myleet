package com.atsyc.dp;

/**
 * Created by doubleyao on 2020-09-17.
 */
public class nthUglyNumber {

    // 三指针法 + 动态规划
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 选出最小的数字
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            // 将该数字对应的指针向前移动一步。
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {

    }

}
