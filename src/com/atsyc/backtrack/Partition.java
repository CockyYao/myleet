package com.atsyc.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by doubleyao on 2020-11-17.
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 */
public class Partition {
    /*
    *  aac
    *   step1 a,ac 判断 a, ac 是否是回文，不是则
    *       继续对ac进行递归，step2 a, a, c 是否都是回文？是，收入
    *
    *   aa,c
    *
    * */

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || "".equals(s)) {
            return res;
        }
        int len = s.length();
        back(s, 0, len, new ArrayList<>());
        return res;
    }

    private void back(String s, int startIndex,
                      int len, List<String> path) {
        // 递归回溯走到头了，直接全部收进来
        if (startIndex == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < len; i++) {
            if (check(s, startIndex, i)) {
                // subString()方法 [ )
                path.add(s.substring(startIndex, i + 1));
                back(s, i + 1, len, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean check(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.substring(0, 2));
    }

    

}
