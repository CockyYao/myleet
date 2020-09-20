package com.atsyc.bit;

/**
 * Created by doubleyao on 2020-09-18.
 */
public class IsPowerOfTwo {


    // 如果一个数是2的n次方，那么这个数用二进制表示时其最高位为1，其余位为0，(val-1)和val都错开了0和1，那么&一定是0。
    private static boolean isPowerOfTwo(int val) {
        return (val & (val - 1)) == 0;
    }

    private static boolean isPowerOfTwoLoseOne(int val) {
        return (val & (val + 1)) == 0;
    }

    // 非2的幂次方转换为2的幂次方， 给定10，返回16
    private int tableSizeFor(int c) {
        int MAXIMUM_CAPACITY = 128;
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16; // 返回n+1就可以了
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // 非2的幂次方转换为2的幂次方， 给定10，返回8
    private int tableSizeMinFor(int x) {
        x |= x >>> 1;
        x |= x >>> 2;
        x |= x >>> 4;
        x |= x >>> 8;
        x |= x >>> 16;

        return x - (x >> 1);
    }

}
