package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 *
 * leetcode 46
 */
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permutations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums,new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            // 递归回溯
            dfs(nums, list);
            // 回到这个点，再移除它
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
