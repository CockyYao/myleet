package com.atsyc.backtrack;

/**
 * Created by doubleyao on 2020-11-20.
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        int[][] dp = new int[m][n];

        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }else {
            dp[0][0] = 1;
        }

        if(dp[0][0] == 0){
            return 0;
        }



        boolean hasRowObs = false;
        boolean hasCloumnObs = false;
        for (int i = 1; i < m; i++) {
            if (hasRowObs) {
                dp[i][0] = 0;
            }
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                hasRowObs = true;
            } else if (!hasRowObs) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (hasCloumnObs) {
                dp[0][j] = 0;
            }
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                hasCloumnObs = true;
            } else if (!hasCloumnObs) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(obstacleGrid[i-1][j] == 1){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                if(obstacleGrid[i][j-1] == 1){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }
        return dp[m-1][n-1];


    }

}
