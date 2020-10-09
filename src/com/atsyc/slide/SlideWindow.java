package com.atsyc.slide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-10-04.
 */
public class SlideWindow {

    private List<Integer> list = new ArrayList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length==0){
            int[] res = new int[]{};
            return res;
        }

        int startIndex = 0;
        int endIndex = nums.length - k;

        for (int i = startIndex; i <= endIndex; i++) {
            list.add(scanMin(nums, i, i + k));
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int scanMin(int[] nums, int from, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = from; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

}
