package com.atsyc.sum;

import java.util.*;

/**
 * Created by doubleyao on 2020-10-16.
 */
public class FourSum {


    public static List<List<Integer>> solution(int[] nums, int target) {
        if (nums == null || nums.length <= 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {

            // 防止重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 最小的四个数加起来超过target
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 最大的四个数加起来小于target
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                // 这里注意是continue，直接跳下一次
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                // 防止重复
                // 这里直接是j>i+1只有移动第二个之后，才有去重的必要
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break; // “剪枝”
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue; // “剪枝”
                }

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                        while (nums[l - 1] == nums[l] && l < r) {
                            l++;
                        }
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                        while (nums[r + 1] == nums[r] && l < r) {
                            r--;
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        l++;
                        r--;
                        while (nums[l - 1] == nums[l] && l < r) {
                            l++;
                        }
                        while (nums[r + 1] == nums[r] && l < r) {
                            r--;
                        }
                    }
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        solution(new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12);
    }

}
