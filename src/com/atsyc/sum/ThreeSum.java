package com.atsyc.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubleyao on 2020-10-16.
 */
public class ThreeSum {

    public List<List<Integer>> solution(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    while (nums[k] == nums[k + 1] && j<k){
                        k--;
                    }
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                    while (nums[k] == nums[k + 1] && j < k) {
                        k--;
                    }
                }
            }

        }
        return result;
    }

}
