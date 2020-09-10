package com.atsyc.recursive;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    // 思路，三个变量，不断移动，来回替换
    public static int fib(int n) {
        if(n == 1 || n == 2 ){
            return 1;
        }
        int a = 1, b = 1;
        int res = 0;
        while (n > 2) {
            res = (a + b)%1000000007;
            a = b;
            b = res;
            n--;
        }
        return res;
    }
}
