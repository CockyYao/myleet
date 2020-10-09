package com.atsyc.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  https://www.jianshu.com/p/ca326326c530
 *  假设有m种硬币 {v1,v2,...,vm} 组成sum
 *
 *
 *
 *  假设根据最后一个vm的系数，系数取值范围是:{0,1,2,...,k},其中k=sum/vm
 *
 *  sum = x1 * v1 + x2 * v2 + ... + 0 * vm
 *  sum = x1 * v1 + x2 * v2 + ... + 1 * vm
 *  sum = x1 * v1 + x2 * v2 + ... + 2 * vm
 *  ...
 *  sum = x1 * v1 + x2 * v2 + ... + k * vm
 *
 *  dp[i][sum] 表示i种硬币，组合成sum的方式
 *
 *  递推公式
 *
 *  dp[i][sum] = dp[i-1][sum] + dp[i-1][sum-vm] + dp[i-1][sum-2*vm] + ... + dp[i-1][sum-k*vm]
 *
 *
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


    private static final int[] coins = {1,5,10,25};




    // 求解所有的个数
    public static int change1(int[] coins, int n) {

        int[][] dp = new int[coins.length + 1][n + 1];
        // 目标： dp[4][n]
        // 初始化
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0; // 0种硬币 组成 i元
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;//i种硬币 组成 0元，只有一种，系数全部为0
        }

        for (int i = 1; i < coins.length + 1; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= n; j++) {
                if (j >= coin) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[coins.length][n];
    }


    public static int change2(int[] coins, int n) {

        int[][] dp = new int[coins.length + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0; // 0种硬币 组成 i元
        }
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 1;//i种硬币 组成 0元，只有一种，系数全部为0
        }

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= n / coin; k++) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][n - k * coin];
                }
            }
        }
        return dp[coins.length][n];
    }



    public static void main(String[] args) {
        System.out.println(change1(new int[]{5, 2, 1}, 11));
    }

}
