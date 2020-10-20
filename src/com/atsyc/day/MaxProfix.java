package com.atsyc.day;

/**
 * Created by doubleyao on 2020-10-15.
 */
public class MaxProfix {

    public int maxProfit(int[] prices) {

        int ans = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            int tmp = prices[i];
            for (int j = i - 1; j >= 0; j--) {
                if (tmp > prices[j] && tmp - prices[j] > ans) {
                    ans = tmp - prices[j];
                }
            }
        }
        return ans == -1 ? 0 : ans;
    }

}
