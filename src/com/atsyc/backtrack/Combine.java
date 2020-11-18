package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-14.
 */
public class Combine {

    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        dfs(nums, new ArrayList<>(),k,0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, int k, int startIndex) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, k, i + 1);
            list.remove(list.size() - 1);
        }

    }

}
