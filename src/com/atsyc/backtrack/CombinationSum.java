package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-11.
 *
 * 39
 */
public class CombinationSum {


    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    // nums[] 数组中的数字可以被无重复地选出来 使用
    private static void dfs(int[] nums, int target, List<Integer> list, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                list.add(nums[i]);
                // nums[] 数组中的数字可以被无重复地选出来 使用，所以这里的index 选择 i
                dfs(nums, target - nums[i], list,  i);
                list.remove(list.size() - 1);
            }
        }
    }

}
