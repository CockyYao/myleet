package com.atsyc.day;

/**
 *
 *
 * https://leetcode-cn.com/problems/word-search/
 *
 * https://leetcode-cn.com/problems/word-search/solution/hui-su-suan-fa-qiu-jie-by-sdwwld-2/
 *
 * https://leetcode-cn.com/problems/word-search/solution/shou-hua-tu-jie-79-dan-ci-sou-suo-dfs-si-lu-de-cha/
 */
public class T4 {

    public static boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean f = dfs(board, words, i, j, 0);
                if (f) {
                    return true;
                }
            }
        }
        return false;
    }


    // 使用了一个index来标记
    public static boolean dfs(char[][] board, char[] words,
                              int row, int cloumn,
                              int index) {

        // 越界 直接 返回
        if (row >= board.length || row < 0 || cloumn < 0 || cloumn >= board[0].length) {
            return false;
        }

        // 找到了或者已经访问过了
        if (words[index] != board[row][cloumn]) {
            return false;
        }

        // 找到了
        if (index == words.length-1) {
            return true;
        }
        char tmp = board[row][cloumn];
        board[row][cloumn] = '*';

        boolean res =  dfs(board, words, row, cloumn - 1, index + 1)|| dfs(board, words,row + 1, cloumn, index+1)
                || dfs(board, words, row, cloumn + 1, index+1) || dfs(board, words,row-1,cloumn,index+1);
        board[row][cloumn] = tmp;

        return res;
    }

    private static void clear(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean contains(String word, String sb) {
        char[] arr = word.toCharArray();
        char[] str = sb.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(str[i] != arr[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
        //"ABCESEEEFS"
        char[][] arr = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','f'}};
        System.out.println(exist(arr,"abceseeefs"));
    }


}
