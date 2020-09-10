package com.atsyc.recursive;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 */
public class KthGrammar {


    public static void main(String[] args) {

    }

    public int kthGram(int N, int K){
        if (N == 1) {
            return 0;
        }
        // 奇数
        if (K % 2 != 0) {
            return kthGram(N - 1, (K + 1) / 2) == 0 ? 0 : 1;
        } else {
            return kthGram(N - 1, K / 2) == 0 ? 1 : 0;
        }
    }
}
