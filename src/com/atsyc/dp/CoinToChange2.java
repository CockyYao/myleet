package com.atsyc.dp;

import java.util.Arrays;

/**
 *
 *  优秀讲解:
 *
 *  https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-suan-fa-si-xiang-by-hikes/
 *
 * https://leetcode-cn.com/problems/coin-change/solution/
 */
public class CoinToChange2 {


    /**
     *
     * f(n) = min{f(n-coin[0]),f(n-coin[1]),...,f(n-coin[i])} + 1;
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        // 用一个数组f，f[i]表示 i元 用coins的纸币，最少可以用几个凑成i元
        int[] f = new int[amount + 1];

        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // i代表i元

            //
            int minCost = Integer.MAX_VALUE;

            // f(i) = min{f(i-coins[0]),f(i-coins[1]),...} + 1
            // 这个for循环用来找到最小的minCost
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (minCost > f[i - coins[j]]) {
                        minCost = f[i - coins[j]];
                    }
                }
            }

            if(minCost != Integer.MAX_VALUE){
                // 有最优解
                f[i] = minCost + 1;
            }else{
                // 无最优解
                f[i] = Integer.MAX_VALUE;
            }

        }

        if(f[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return f[amount];
    }


    public static void main(String[] args) {

    }

}
