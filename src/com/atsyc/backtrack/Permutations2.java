package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-10.
 */
public class Permutations2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 先排序
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(),visited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {

            res.add(new ArrayList<>(list));

            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 再剪枝
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    // 暴力超时
    private boolean exist(List<Integer> list) {
        if (res.size() == 0) {
            return false;
        }
        for (List<Integer> e : res) {
            boolean f = true;
            for (int i = 0; i < e.size(); i++) {
                if (!list.get(i).equals(e.get(i))) {
                    f = false;
                }
            }
            if (f) {
                return true;
            }
        }
        return false;
    }


}
