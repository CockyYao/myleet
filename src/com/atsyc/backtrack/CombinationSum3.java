package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-12.
 */
public class CombinationSum3 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(nums, new ArrayList<>(), n, k, 0);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> list, int target, int k, int startIndex) {
        if (target == 0) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
            }
        }

        if (target < 0 || list.size() >= k) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 单纯的数字1～9，不存在重复的数字，所以这里也不需要判断了

            if (target >= nums[i]) {
                list.add(nums[i]);
                // nums[] 数组的数字 不可以重复使用, 故下一次递归从i+1开始
                dfs(nums, list, target - nums[i], k, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }

}
