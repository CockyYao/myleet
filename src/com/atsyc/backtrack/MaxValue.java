package com.atsyc.backtrack;

/**
 * Created by doubleyao on 2020-11-20.
 *
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 *
 * if(i==0)
 *      dp[0][j] = dp[0][j-1]+grid[0][j]
 *
 *  if(j==0)
 *      dp[i][0] == dp[i-1][0]+grid[i][0]
 *
 *  others
 *      f(i,j) = max{f(i-1,j),f(i,j-1)}+grid[i][j]
 *
 */
public class MaxValue {


    public int maxValue(int[][] grid) {

        // 行
        int m = grid.length;

        // 列
        int n = grid[0].length;


        // [[0]]
        if (n == 1 && m == 1) {
            return grid[0][0];
        }

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];

    }


}
