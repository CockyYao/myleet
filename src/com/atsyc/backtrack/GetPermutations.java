package com.atsyc.backtrack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class GetPermutations {

    // 使用treeSet保存，有序性
    private TreeSet<Integer> set = new TreeSet();

    private  int LEN = 0;
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        dfs(arr, 0, visited, k);
        return String.valueOf(set.pollLast());
    }

    // 直接怼数字，省的字符串转了
    private  void dfs(int[] arr, Integer x, boolean[] visited, int k) {

        // 只需要计算前k个，不然会超时的
        if (set.size() == k) {
            return;
        }
        if (LEN == arr.length) {
            set.add(x);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                LEN++;
                int y = x * 10 + arr[i];
                dfs(arr, y, visited,k);
                LEN--;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // getPermutation(9, 3);
    }


}
