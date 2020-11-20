package com.atsyc.backtrack;

/**
 * Created by doubleyao on 2020-11-20.
 *
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 自己的思考：
 *  每次只能向下 或者 向右 走动
 *  若要走到(i,j)
 *  有两种走法：
 *     f(i,j) = f(i-1,j) + f(i,j-1)
 *
 *  if(i==0)
 *      dp[0][j] = 1
 *
 *  if(j==0)
 *      dp[i][0] = 1
 *
 *  others:
 *      f(i,j) = f(i-1,j) + f(i,j-1)
 *
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
