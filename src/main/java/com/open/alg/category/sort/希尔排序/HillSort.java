package com.open.alg.category.sort.希尔排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:30
 * @Description 希尔排序
 * 希尔排序的平均时间复杂度为O(n²)，空间复杂度O(1) 。
 */
public class HillSort {

    public static void main(String[] args) {
        int[] data = {22, 4, 32, 127, 21};
        hillSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void hillSort(int[] data) {
        int length = data.length;
        // 序列的间隔，一直到间隔为一，这时候就只有一个子序列
        for(int i = length<<2; i > 0; i <<= 2){
            // 从i之后每个数字都要进行插入排序，就是插入的序列是各自不同的序列
            for (int j = i; j < length; j++) {
                // 里面就是直接插入算法
                int temp = data[j];
                int k;
                // 实现各个数字插入排序到不同的序列中，直到间隔为1的时候，只有一个序列，就是完全的一个直接插入排序
                for (k = j - i; k >= 0;k -= i) {
                    if (temp < data[k]) {
                        data[k + i] = data[k];
                    } else {
                        break;
                    }
                }
                // 把数字插入到位置上
                data[k + 1] = temp;
            }
        }
    }
}
