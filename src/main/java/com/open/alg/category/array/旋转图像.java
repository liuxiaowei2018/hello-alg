package com.open.alg.category.array;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 10:24
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 */
public class 旋转图像 {

    //先上下交换，在对角线交换

    class Solution {
        public void rotate(int[][] matrix) {
            int length = matrix.length;
            //先上下交换
            for (int i = 0; i < length / 2; i++) {
                int[] temp = matrix[i];
                matrix[i] = matrix[length - i - 1];
                matrix[length - i - 1] = temp;
            }
            //在按照对角线交换
            for (int i = 0; i < length; ++i) {
                for (int j = i + 1; j < length; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

}
