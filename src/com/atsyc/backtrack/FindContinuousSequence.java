package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-20.
 *
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * 回溯法
 */
public class FindContinuousSequence {

    private static List<List<Integer>> res = new ArrayList<>();


    public static List<List<Integer>> findContinuousSequence(int target) {
        int bound = target % 2 == 0 ? target / 2 : target / 2 + 1;
        int[] nums = new int[bound];
        for (int i = 0; i < bound; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < bound; i++) {
            help(nums, new ArrayList<>(), target, i);
        }

        return res;
    }



    private static void help(int[] nums, List<Integer> list, int target, int start) {

        int sum = 0;
        for (int i = start; i < nums.length; i++) {
            sum = sum + nums[i];
            list.add(nums[i]);
            if (target == sum) {
                res.add(new ArrayList<>(list));
            }
            if (target < sum) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }

}
