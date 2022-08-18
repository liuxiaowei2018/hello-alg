package com.open.alg.category.sort.选择排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:39
 * @Description 简单选择排序
 * 简单选择排序的时间复杂度为O(n²)
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int[] data = {22, 4, 32, 127, 21};
        simpleSelectSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void simpleSelectSort(int[] data) {
        int length = data.length;
        // 确定每次开始的位置
        for (int i = 0; i < length; i++) {
            // 设定开始数字为最小的值最小值
            int min = data[i];
            int flag = i;
            // 把最小值存放到min,从开始数字向后一个个和min比较，再把最小值存放到min
            for (int j = i+1;j<length;j++) {
                if (min > data[j]) {
                    min = data[j];
                    flag = j;
                }
            }
            if (flag != i) {
                data[flag] = data[i];
                data[i] = min;
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0,n=nums.length; i < n-1; ++i) {
            int min = i;
            for (int j = i; j < n; ++j) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
