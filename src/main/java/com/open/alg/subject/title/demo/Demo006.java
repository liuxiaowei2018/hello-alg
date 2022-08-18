package com.open.alg.subject.title.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title: Demo006
 * @author: 伟酱
 * @date 2020/7/10 14:44
 * 题目:输入三个整数x,y,z，请把这三个数由小到大输出
 */
public class Demo006 {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int[] arr = {x,y,z};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        //求x,y,z的最小值
        //min(x, y, z);
    }

    private static void min(int x, int y, int z) {
        int min = x;
        if (min<y){
            min = y;
        }
        if (z <min){
            min = z;
        }
        System.out.println(min);
    }
}
