package com.atsyc.dp;

/**
 *  求解最长回文子序列的长度
 *
 *  babad 其中 bab就是回文串
 *
 *
 */
public class LPS {


    public static void main(String[] args) {
        // "bbbab"的最长回文子序列长度为4，注意是子序列，不是子串
        System.out.println(solution("bbbab"));
    }



    /**
     * 给定一个字符串，求出得到最大的长度的回文串
     */
    public static int solution(String s) {
        return lpsDp(s.toCharArray());
    }



    // 递归，可能会超时
    static int lps(char[] arr, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (arr[i] == arr[j]) {
            return lps(arr, i + 1, j - 1) + 2;
        }
        return Math.max(lps(arr, i, j - 1), lps(arr, i + 1, j));
    }

    // 动态规划
    static int lpsDp(char[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int k = 0; k < dp.length; k++) {
            dp[k][k] = 1;
        }
        int ans = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                if (ans < dp[i][j]) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }



}
