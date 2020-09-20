package com.atsyc.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 */
public class CoinToChange {

    // 25,10,5,1
    private static List<List<Integer>> list = new ArrayList<>();
    private static List<Integer> tmp = new ArrayList<>();
    // 递归 + 回溯 会超时
    public static int waysToChange(int n) {

        help(n);
        return list.size();
    }

    private static void help(int n) {
        if (n == 0) {

            for(List<Integer> e : list){
                if(e.size() == tmp.size()){
                    return;
                }
            }
            list.add(new ArrayList<>(tmp));
            System.out.println(tmp);
            return;
        }
        if (1 <= n && n < 5) {
            f(1,n);
        }
        if(n>=5 && n<10){
            f(1,n);
            f(5,n);
        }

        if(n>=10 && n<25){
            f(1,n);
            f(5,n);
            f(10,n);
        }
        if(n>=25){
            f(1,n);
            f(5,n);
            f(10,n);
            f(25,n);
        }
    }

    private static void f(int x,int n){
        tmp.add(x);
        help(n-x);
        tmp.remove(tmp.size()-1);
    }


    // dp[i][j] 使用前i种硬币计算j分的表示法种数 令coins=[25, 10, 5, 1]
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]] + dp[i-1][j-2*coins[i]] + ... dp[i-1][j-k*coins[i]]
    // j >= k*coins[i]
    // dp[i][j-coins[i]] = dp[i-1][j-coins[i]] + dp[i-1][j-2*coins[i]] + ... dp[i-1][j-k*coins[i]]
    // dp[i][j] - dp[i][j-coins[i]] = dp[i-1][j]
    // dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j]


    private static final int[] coins = {25, 10, 5, 1};

    public static int change(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(61));
        System.out.println(change(61));
    }

}
