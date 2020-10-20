package com.atsyc.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by doubleyao on 2020-10-16.
 */
public class TwoSum {

    public List<Integer> solution(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                list.add(map.get(nums[i]));
                list.add(i);
                return list;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return list;

    }

}
