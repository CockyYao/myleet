package com.atsyc.dp;

/**
 *
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 */
public class Cutting {


    private static int index = 0;

    private static int ans = 0;

    public static int cuttingRope(int n) {

        help(n, new int[n]);
        return ans;
    }

    // 动态规划
    // F(n)=Max{i*(n-i),i*F(n-i)}
    // i*(n-i) 就是剪成两段
    // i*F(n-i) 就是i一段 + n-i这段继续剪
    private static int cutting(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 剪 或者 不剪
                dp[i] = Math.max(Math.max(j * (i - j), dp[i - j] * j), dp[i]);
            }
        }

        return dp[n];

    }

    // 递归 + 回溯
    private static void help(int n, int[] arr) {

        if (n == 0 && index != 1) {
            int tmp = 1;
            for (int i = 0; i < index; i++) {
                tmp = tmp * arr[i];
            }
            if (ans < tmp) {
                ans = tmp;
            }
            return;
        }

        for (int i = 1; i <= n/2; i++) {
            arr[index] = i;
            index++;
            help(n - i, arr);
            index--;
        }
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }


}
