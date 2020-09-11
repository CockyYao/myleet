package com.atsyc.backtrack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/submissions/
 *
 * 回溯
 */
public class PermutationString {

    // 使用set，降低延时
    private static Set<String> lists = new HashSet<>();

    private static int LEN;

    // "aab"
    // "abc"
    public static String[] permutation(String s) {
        if (s == null || "".equals(s)) {
            return new String[0];
        }
        LEN = s.length();
        boolean[] visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        dfs(arr, new StringBuilder(),visited);
        if (lists.size() == 0) {
            return new String[0];
        }
        return lists.toArray(new String[lists.size()]);
    }

    void dfs(char[] arr, StringBuilder s) {
        if (s.length() == LEN) {
            lists.add(s.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            String tmp = String.valueOf(arr[i]);
            boolean exist = s.toString().contains(tmp);
            if (!exist) {
                s.append(arr[i]);
                dfs(arr, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }


    static void dfs(char[] arr, StringBuilder s, boolean[] visited) {
        if (s.length() == LEN) {
            lists.add(s.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                s.append(arr[i]);
                dfs(arr, s, visited);
                visited[i] = false;
                s.deleteCharAt(s.length() - 1);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }


}
