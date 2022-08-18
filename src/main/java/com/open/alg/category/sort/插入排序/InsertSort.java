package com.open.alg.category.sort.插入排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:23
 * @Description 直接插入
 * 直接插入排序的平均复杂度为O(n²)，最坏时间复杂度：O(n²)，空间复杂度：O(1)，没有分配内存。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] data = {22, 4, 32, 127, 21};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void insertSort(int[] data) {
        int length = data.length;
        int temp;
        // 设定插入次数，即循环次数[1个数的那次不用插入]
        for (int i = 1; i < length; i++) {
            // 要插入的数 temp
            temp = data[i];
            // 已经排序好的序列元素个数 j
            int j = i -1;

            // 序列从后到前循环，将大于temp的数向后移动一格
            while (j >= 0 && data[j] > temp) {
                // 若前面的数大，则往后挪一位
                data[j + 1] = data[j];
                j--;
            }
            // 找到这个位置，插入数据
            data[j + 1] = temp;
        }
    }

    /**
     * 插入排序 简化版
     *
     * @param nums
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1, j, n = nums.length; i < n; ++i) {
            int num = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > num; --j) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }
}
