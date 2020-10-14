package com.atsyc.dp;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 请注意 子串 和 子序列 是不一样的 orzzzzz
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Lps2 {


    // 动态规划
    static String lpsDp(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        // dp[i][j]代表 i 到 j的字符串是否为回文的
        // f(i,j) = true --> f(i+1,j-1)=true && s[i]==s[j]
        // f(i,j) = true , i == j
        // f(i,j) = true , j = i+1 && s[i]==s[j]

        /*
         *  递推公式：
         *
         *  i ---> j   dp[i][j] = true 则代表i到j是回文，false则不是
         *  dp[i][j] = ?
         *      if(arr[i] == arr[j]){
         *          if(j=i+1){
         *              dp[i][j]=true
         *          }else{
         *              dp[i][j] = dp[i+1][j-1]
         *          }
         *      }
         *      else
         *          dp[i][j] = false
         *
         *
         * */
        boolean[][] dp = new boolean[s.length()][s.length()];
        int from = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (end - from <= j - i) {
                        from = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(from, end + 1);
    }

}
