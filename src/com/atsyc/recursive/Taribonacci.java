package com.atsyc.recursive;

/**
 * Created by doubleyao on 2020-09-16.
 */
public class Taribonacci {


    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 超时
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] a = new int[1000];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i-1] + a[i-2] + a[i-3];
        }
        return a[n];
    }


    public static void main(String[] args) {

    }

}
