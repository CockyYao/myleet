package com.atsyc.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {


    /*
     *
     *   w1[0....i] w2[0.....j]
     *
     * 假设始终针对w1做操作
     *
     *   1. 插入操作
     *       把w2的某个字符插入到这边
     *
     *       子问题:w1[0...i] w2[0....j-1]
     *
     * 2. 删除操作
     *       把w1的某个字符删掉
     *       w1[0....i-1] w2[0.....j]
     *
     *   3. 替换操作
     *       把w1的某个字符替换成w2
     *       w1[0.....i-1] w2[0....j-1]
     *
     * dp[i][j]
     *
     *   if s(i) == s(j)
     *       dp[i][j] = min{dp[i-1][j-1],dp[i-1][j]+1,dp[i][j-1]+1}
     *   else
     *       dp[i][j] = min{dp[i-1][j-1]+1,dp[i-1][j]+1,dp[i][j-1]+1}
     *
     *
     * */
    public int editDistance(String word1, String word2) {

        if (isBlank(word1) || isBlank(word2)) {
            return isBlank(word1) ? word2.length() : word1.length();
        }

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        dp[0][0] = 0;
        for(int j=1;j<len2+1;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<len1+1;i++){
            dp[i][0] = i;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1] + 1), dp[i - 1][j] + 1);

                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1]+1, dp[i][j - 1] + 1), dp[i - 1][j] + 1);
                }
            }
        }
        return dp[len1][len2];
    }



    private boolean isBlank(String str){
        return null == str || "".equals(str);
    }


}
