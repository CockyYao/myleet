package com.atsyc.backtrack;

import java.util.*;

/**
 * Created by doubleyao on 2020-11-14.
 * 17
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
 */
public class LetterCombines {
    static Map<Integer, Character[]> map = new HashMap<>();
    static {
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
    }

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits == ""){
            return new ArrayList<>();
        }


        char[] nums = digits.toCharArray();
        if(nums.length == 1){

        }

        return null;

    }

    private void dfs(char[] nums, List<Character> list, int startIndex) {


        for (int i = startIndex; i < nums.length; i++) {

        }
    }

}
