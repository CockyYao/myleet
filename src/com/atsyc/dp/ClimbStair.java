package com.atsyc.dp;

/**
 * Created by doubleyao on 2020-09-28.
 */
public class ClimbStair {

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs1(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
