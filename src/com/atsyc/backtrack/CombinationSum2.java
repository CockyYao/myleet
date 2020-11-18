package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-11.
 *
 * 这个题目在于去重
 *
 * 39,40,216,377,
 *
 * 类似回溯算法:
 *  17,22,46,47,51,77
 *
 * leetcode 40
 */
public class CombinationSum2 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        //back(candidates, target, new ArrayList<>(), visited);
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }

    private static void back(int[] nums, int target, List<Integer> list, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            if (!visited[i] && target-nums[i] >=0) {
                visited[i] = true;
                list.add(nums[i]);
                back(nums, target - nums[i], list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    private static void dfs(int[] nums, int target, List<Integer> list,int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // 排序排好了，然后保证相同的数字 在递归的时候，每一层只能取一次
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - nums[i] >= 0) {
                list.add(nums[i]);
                // nums[] 每个数字只能用一次！！！，所以index 从 i+1 开始
                dfs(nums, target - nums[i], list,  i + 1);
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

}
