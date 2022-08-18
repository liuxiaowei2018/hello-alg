package com.open.alg.category.sort.冒泡排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:46
 * @Description 冒泡排序
 * 冒泡排序的最好时间复杂度为O(n),最坏时间复杂度为O(n²),平均时间复杂度为O(n²),空间复杂度为O(1),它是一种稳定的排序算法。
 */
public class BubbleSort {

    /**
     * 冒泡排序优化第二版
     * 第一版优化增加flag标记，没有数字交换直接return，最优时间复杂度O(n)
     * 第二版优化，增加tempPostion记录内循环最后一次交换的位置，来缩减内循环的次数
     */
    public static void bubbleSort(int[] array) {
        int len = array.length - 1;
        // 开辟一个临时空间, 存放交换的中间值
        int temp;
        // 记录最后一次交换的位置
        int tempPostion = 0;
        // 要遍历的次数
        for (int i = 0; i < array.length - 1; i++) {
            // 设置一个标志位
            int flag = 1;
            // 依次比较相邻两个数的大小，遍历一次后，会将前面没有排好序的最大值放到后面位置
            for (int j = 0; j < len; j++) {
                // 比较相邻的元素，如果前面的数大于后面的数，交换
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    // 发生交换，标志位置0
                    flag = 0;
                    // 记录交换的位置
                    tempPostion = j;
                }
            }
            // 把最后一次交换的位置给len，来缩减内循环的次数
            len = tempPostion;
            // 如果没有交换过元素，则已经有序
            if (flag == 1) {
                System.out.println(Arrays.toString(array));
                return;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序 第一版
     *
     * @param nums
     */
    private static void bubbleSort1(int[] nums) {
        boolean hasChange = true;
        for (int i = 0, n = nums.length; i < n - 1 && hasChange; ++i) {
            hasChange = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swaps(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    private static void swaps(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        bubbleSort1(nums);
        System.out.println(Arrays.toString(nums));
    }

}
