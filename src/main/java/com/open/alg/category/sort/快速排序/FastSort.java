package com.open.alg.category.sort.快速排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:47
 * @Description 快速排序
 * 排的时间复杂度达到了 O(n²)，但是在大多数情况下都比平均时间复杂度为 O(n logn) 的排序算法表现要更好
 */
public class FastSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        if (a.length <= 1) {
            return;
        }
        if (i >= j) {
            return;
        }
        int index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index)
                j--;
            if (a[j] < index)
                a[i++] = a[j];
            while (i < j && a[i] <= index)
                i++;
            if (a[i] > index)
                a[j--] = a[i];
        }
        a[i] = index;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

    /**
     * 快速排序 简化版
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left - 1, j = right + 1;
        int x = nums[left];
        while (i < j) {
            while (nums[++i] < x) ;
            while (nums[--j] > x) ;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

}
