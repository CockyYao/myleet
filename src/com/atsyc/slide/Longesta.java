package com.atsyc.slide;

/**
 * Created by doubleyao on 2020-10-06.
 */
public class Longesta {


    // bbabb -> bbbbb
    public static int longestOnes(char[] A, int K) {

        int ans = 0;//结果

        int zero = 0;//滑动窗口中a的个数

        int start = 0;//滑动窗口左边界

        int end = 0;//滑动窗口右边界

        while (end < A.length) {
            if (A[end] == 'a') {
                zero++;
                if (zero <= K) {
                    ans = Math.max(end - start + 1, ans);
                } else {
                    // 移动左边的指针
                    while (zero > K) {
                        if (A[start] == 'a') {
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

    public static void main(String[] args) {
        System.out.println(longestOnes("bbaabb".toCharArray(),1));
    }

}
