package com.atsyc.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubleyao on 2020-09-20.
 */
public class CountString {

    // abcd
    // a
    // a,ab
    // c,bc,abc
    // d,cd,bcd,abcd
    private static List<String> list = new ArrayList<>();

    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                char [] res = newChar(chars,j,i);
                if(isHuiWen(res)){
                    list.add(String.valueOf(res));
                }
            }
        }
        return list.size();
    }

    private static char[] newChar(char[] arr, int s, int e) {
        if (s == e) {
            return new char[]{arr[e]};
        }
        char[] res = new char[e - s + 1];
        int j = 0;
        for (int i = s; i <= e; i++) {
            res[j++] = arr[i];
        }
        return res;
    }


    private static boolean isHuiWen(char[] arr) {
        if (arr.length == 1) {
            return true;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

}
