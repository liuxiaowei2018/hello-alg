package com.open.alg.subject.title.demo;

/**
 * @title: Demo1
 * @author: 伟酱
 * @date 2020/7/10 14:01
 * 题目：有一对兔子，从出生后第3个月起每个月都生一对兔子
 * 小兔子长到第四个月后每个月又生一对兔子
 * 假如兔子都不死，问每个月的兔子总对数为多少？
 */
public class Demo001 {

    // 分析模型 [1,1,2,3,5...]

    public static void main(String[] args) {
        int count = count(4);
        System.out.println(count);
    }

    private static int count(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return count(i - 1) + count(i - 2);
    }
}
