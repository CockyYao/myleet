package com.atsyc.recursive;

/**
 * Created by doubleyao on 2020-09-02.
 */
public class IsNumber {


    private static int index = 0;

    private static boolean scanUnsignedInteger(String str) {
        int before = index;
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
        }
        return before < index;
    }

    private static boolean scanInteger(String str) {
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        // 出现了一次 加 减 后面是无符号
        return scanUnsignedInteger(str);
    }


    /**
     *
     * A.BeC
     *
     * A.BEC
     *
     *
     *
     */

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s + "|";

        // 去除头部的空格
        while (s.charAt(index) == ' ') {
            index++;
        }

        boolean numeric = scanInteger(s);

        if (s.charAt(index) == '.') {
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //注意scanUnsignedInteger要在前面，否则不会进
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if ((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            //指数部分
            //e或E的两边都要有数字，所以用&&
            numeric = numeric && scanInteger(s);
        }
        //跳过尾部空格
        while (s.charAt(index) == ' ') {
            index++;
        }
        return numeric && s.charAt(index) == '|';
    }

    public static void main(String[] args) {
        System.out.println(isNumber("5E+3"));
    }


}
