package com.open.alg.category.algorithm.array;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 10:05
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 */
public class 有效的数独 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int length = board.length;
            int[][] line = new int[length][length];
            int[][] column = new int[length][length];
            int[][] cell = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                        return false;
                    //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                    line[i][num] = column[j][num] = cell[k][num] = 1;
                }
            }
            return true;
        }
    }
}
