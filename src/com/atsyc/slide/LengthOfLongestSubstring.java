package com.atsyc.slide;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doubleyao on 2020-10-14.
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int ans = -1;
        char[] arr = s.toCharArray();
        if (arr.length == 1) {
            return 1;
        }
        while (r < arr.length) {
            if (!hasRepeat(arr, l, r)) {
                int tmp = r - l + 1;
                if (tmp > ans) {
                    ans = tmp;
                }
                r++;
            } else {
                while (hasRepeat(arr, l, r)) {
                    l++;
                }
            }
        }
        return ans;
    }

    // [l,r] 区间是否存在重复的字符
    private static boolean hasRepeat(char[] arr, int l, int r) {
        if (l == r) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            set.add(arr[i]);
        }
        if(set.size() == r - l + 1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }


}
