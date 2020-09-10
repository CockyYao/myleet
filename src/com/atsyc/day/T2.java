package com.atsyc.day;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归+huishu
 * https://leetcode-cn.com/problems/combination-sum/solution/fei-chang-xiang-xi-de-di-gui-hui-su-tao-lu-by-re-2/
 * <p>
 * 动态规划
 * https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
 */
public class T2 {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 0 || candidates == null || candidates.length == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                // 因为每个数字都可以使用无数次，所以递归可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                // 引用传递，所以数字变多了
                list.remove(list.size() - 1);
            }
        }

    }

}
