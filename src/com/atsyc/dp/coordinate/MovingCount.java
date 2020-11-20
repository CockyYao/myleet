package com.atsyc.dp.coordinate;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * 机器人的运动范围
 */
public class MovingCount {

    private int cnt = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, m, n, k, visited);
        return cnt;
    }

    private void dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        // 注意 坐标的移动范围在 [0,m-1]，[0,n-1]
        if (x >= m || y >= n || visited[x][y]) {
            return;
        }
        if (getSum(x) + getSum(y) <= k) {
            cnt++;
            visited[x][y] = true;
            // 由于题目的限制，这里直接就向右，或者向下递归就行
            dfs(x + 1, y, m, n, k, visited);
            dfs(x, y + 1, m, n, k, visited);
        }
    }

    private int getSum(int m) {
        if (m == 0) {
            return 0;
        }
        int sum = 0;
        int x = m;
        while (x != 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;
    }

}
