package com.atsyc.tree;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-cong-yuan-shi-de-di-/
 */
public class NumTree {




    // 速度慢
    public int solve1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans + solve1(i) * solve1(n - i);
        }
        return ans;
    }

    // 优化1：其实1，2，3与4,5,6构造出的BST是一样多的，所以你没必要多算好几次
    public int solve2(int n) {
        int[] record = new int[n+1];
        // record[i]记录了 1,2,3,...,i可以构造的BST数量
        record[0] = 1;
        return helper(n,record);
    }

    public int helper(int n, int[] record) {
        if (n == 0 || n == 1) {     // 递归出口
            return 1;
        }
        if (record[n] > 0) {        // 如果计算过了
            return record[n];       // 提前返回结束递归求解，省时省空间
        }
        for (int i = 1; i <= n; i++) {
            record[n] += helper(i - 1, record) * helper(n - i, record);
        }
        return record[n];
    }


    // dp数组


}
