package com.atsyc.slide;

/**
 * Created by doubleyao on 2020-10-17.
 */
public class LongestCommonPrefix {

    private static int index =0;
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String random = select(strs);
        if (random == null) {
            return "";
        }
        for (int i = random.length(); i > 0; i--) {
            String base = getSubString(random, 0, i);
            if (allContains(strs, base)) {
                return base;
            }
        }
        return "";
    }

    private static String select(String[] strs) {
        for (int i=0;i<strs.length;i++) {
            String str = strs[i];
            if (str != null && !"".equals(str)) {
                index = i;
                return str;
            }
        }
        return null;
    }

    private static String getSubString(String str, int l, int r) {
        return str.substring(l, r);
    }

    private static boolean allContains(String[] strs, String base){
        for (int j = 0; j < strs.length ; j++) {
            if(j==index){
                continue;
            }
            if(!strs[j].startsWith(base)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String [] strings = new String[]{"c","acc","ccc"};
        System.out.println(longestCommonPrefix(strings));
    }



}
