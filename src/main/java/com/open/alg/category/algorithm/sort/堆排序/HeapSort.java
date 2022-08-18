package com.open.alg.category.algorithm.sort.堆排序;

import java.util.Arrays;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:43
 * @Description 堆排序
 * 时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] data = {22, 4, 32, 127, 21};
        maxHeapSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void maxHeapSort(int[] array) {
        int i;
        int len = array.length;
        // 构建大顶堆
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, len);
        }
        // 堆顶是最大值，交换堆顶和最后一个数，再重新调整最大堆，下一次循环   i--
        for (i = len - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustMaxHeap(array, 0, i);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void adjustMaxHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp = a[pos]; 2 * pos + 1 < len; pos = child) {
            // 数组从0开始，r(i)>=r(2i) r(i)>=r(2i+1)  对应 pos => 2 * pos + 1 和 2 * pos +2
            child = 2 * pos + 1;
            // 有右孩子，且右孩子数值更大
            if (child + 1 < len && a[child] < a[child + 1]) {
                child++;
            }
            // 最大的孩子大于根节点
            if (a[child] > temp) {
                a[pos] = a[child];
            } else {
                break;
            }
        }
        a[pos] = temp;
    }
}
