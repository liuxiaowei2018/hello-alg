package com.open.alg.category.sort.基数排序;

import java.util.ArrayList;

/**
 * @Author liuxiaowei
 * @Date 2021/1/28 21:48
 * @Description 基数排序
 */
public class RadixSort {

    public static void radixSort(int[] array) {
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            queue.add(new ArrayList<>());// 创建一个基数从0---9 每个数字上都是一个list
        }
        // 找到最大值，并判断最大值是几位数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        for (int i = 0; i < time; i++) {// 循环每一个位数（个位、十位、百位）
            for (int j = 0; j < array.length; j++) {// 循环数组，取每一个值
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue3 = queue.get(x);

                queue3.add(array[j]);
                queue.set(x, queue3);
            }
            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue4 = queue.get(k);
                    array[count] = queue4.get(0);
                    queue4.remove(0);
                    count++;
                }
            }
        }
    }

}
