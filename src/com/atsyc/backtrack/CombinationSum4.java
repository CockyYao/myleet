package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-12.
 */
public class CombinationSum4 {


    private static List<List<Integer>> res = new ArrayList<>();



    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums,target,new ArrayList<>());
        return res.size();
    }

    private static void dfs(int[] nums, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                list.add(nums[i]);
                dfs(nums, target - nums[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum4(new int[]{1,2,3},4);
    }

}
