package com.atsyc.dp;

/**
 *
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 */
public class IsSubsequence {

    private int index = -1;

    public boolean isSubsequence(String s, String t) {

        char[] arr = t.toCharArray();
        char[] sub = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (!help(arr, index + 1, sub[i])) {
                return false;
            }
        }
        return true;

    }

    boolean help(char[] arr, int startIndex, char ch) {
        for (int i = startIndex; i < arr.length; i++) {
            if (ch == arr[i]) {
                index = i;
                return true;
            }
        }
        return false;
    }


}
