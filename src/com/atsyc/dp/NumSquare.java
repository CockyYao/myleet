package com.atsyc.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquare {

    private static List<Integer> list = new ArrayList<>();

    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
    // 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    // dp[n] = min{dp[n-x1],dp[n-x2],dp[n-x3]...dp[n-xi]} + 1
    public static int numSquares(int n) {
        for (int i = 1; i * i <= n; i++) {
            list.add(i*i);
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer j : list) {
                if (j <= i && dp[i - j] < min) {
                    min = dp[i - j];
                }
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(13);
    }




}
