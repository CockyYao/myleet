package com.atsyc.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 *  https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 *
 *  https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-jin-shuang-100tu-wen-pei-he-by-zu/
 */
public class RestoreIpAddress {

    List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        int[] segments = new int[4];
        backtrack(s, 0, 0, segments);
        return res;
    }

    /**
     * @param s
     * @param start      可选择字符串的起始索引
     * @param segmentNum 已经得到的整数个数
     * @param segments
     */
    public void backtrack(String s, int start, int segmentNum, int[] segments) {
        if (segmentNum == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");

                }
                sb.append(segments[3]);
                res.add(sb.toString());
            }
            return;
        }

        if(start == s.length()){
            return;
        }

        if (s.charAt(start) == '0') {
            segments[segmentNum] = 0;
            backtrack(s, start + 1, segmentNum + 1, segments);
        }

        int temp = 0;
        for (int end = start; end < s.length(); end++) {
            temp = temp * 10 + (s.charAt(end) - '0');
            if (temp > 0 && temp <= 255) {
                segments[segmentNum] = temp;
                backtrack(s, end + 1, segmentNum + 1, segments);
            } else {
                break;
            }
        }

    }

}
