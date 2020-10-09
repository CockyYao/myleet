package com.atsyc.slide;

/**
 * Created by doubleyao on 2020-10-04.
 */
public class LongestOnes {

    public static void main(String[] args) {

    }

    public int longestOnes(int[] A, int K) {
        int ans = 0;//结果
        int zero = 0;//滑动窗口中0的个数
        int start = 0;//滑动窗口左边界
        int end = 0;//滑动窗口右边界

        while (end < A.length) {
            if (A[end] == 0) {
                zero++;
                if (zero <= K) {
                    // 更新ans
                    ans = Math.max(end - start + 1, ans);
                } else {
                    // 移动左指针
                    while (zero > K) {
                        if (A[start] == 0) {
                            zero--;
                        }
                        start++;
                    }
                }
            } else {
                ans = Math.max(end - start + 1, ans);
            }
            end++;
        }
        //最后出循环时特判一下
        if (start < end) {
            ans = Math.max(end - start, ans);
        }
        return ans;
    }
}
