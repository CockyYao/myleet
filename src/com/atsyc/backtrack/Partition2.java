package com.atsyc.backtrack;

/**
 * Created by doubleyao on 2020-11-18.
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/submissions/
 */
public class Partition2 {

    private int cnt = Integer.MAX_VALUE;

    public int minCut(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        back(s, 0, len, 0);
        return cnt;
    }

    private void back(String s, int startIndex, int len, int times) {
        if (len == startIndex) {
            if (times < cnt) {
                cnt = times;
            }
        }
        for (int i = startIndex; i < len; i++) {
            if (check(s, startIndex, i)) {
                times++;
                back(s, i + 1, len, times);
                times--;
            }
        }
    }

    private static boolean check(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition2 p  = new Partition2();
        p.minCut("aab");
    }

}
