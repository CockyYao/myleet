package com.atsyc.dp;

import java.util.*;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class Lps3 {

    public int longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (data.containsKey(arr[i])) {
                data.put(arr[i], data.get(arr[i]) + 1);
            } else {
                data.put(arr[i], 1);
            }
        }
        int res = 0;
        boolean exist = false;
        for (Character ch : data.keySet()) {
            if (data.get(ch) % 2 == 0) {
                res += data.get(ch);
            } else {
                // 这里为什么减去1
                res = res + data.get(ch) - 1;
            }
        }
        if (exist) {
            res++;
        }
        return res;
    }


}
