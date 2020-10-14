package com.atsyc.slide;

/**
 *
 * https://javaniuniu.com/leetcode/2020/0511/006
 * 求解优美子数组
 */
public class NumberOfSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;

        int leftEvtCnt = 0;
        int rightEvtCnt = 0;

        // 滑动窗口中 奇数的个数
        int count = 0;

        // 优美子数组的个数
        int res = 0;
        while (r < nums.length) {

            if ((nums[r++] & 1) == 1) {
                count++;
            }

            if (count == k) {
                int tmp = r;
                while (r < nums.length && (nums[r] % 2 == 0)) {
                    r++;
                }
                rightEvtCnt = r - tmp;
                leftEvtCnt = 0;
                while (l < nums.length && (nums[l] % 2 == 0)) {
                    leftEvtCnt++;
                    ++l;
                }
                res = res + (leftEvtCnt + 1) * (rightEvtCnt + 1);
                count--;
                l++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2044,96397,50143};
        numberOfSubarrays(a, 1);
    }

    /*
    *
    * public int numberOfSubarrays(int[] nums, int k) {
        // 滑窗
        int res=0,count=0;
        int left=0,right=0;
        int tmp=0;
        while (right<nums.length){
            if (count<k){
                count+=nums[right]&1;
                right++;
            }
            if (count==k){
                tmp=0;
                while (count==k){
                    ++res;++tmp;
                    count-=nums[left]&1;
                    ++left;
                }
            }else res+=tmp;
        }
        return res;
    }
    *
    *
    *
    *
    * */


}
