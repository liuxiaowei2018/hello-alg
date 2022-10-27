package com.open.alg.subject.subject2021.demo;

/**
 * @title: Demo009
 * @author: 伟酱
 * @date 2020/7/10 14:29
 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class Demo009 {

    public static void main(String[] args) {
        // 数列之和
        float sum = 0f;
        // 分子
        float numerator = 1f;
        // 分母
        float denominator = 1f;
        float temp = 0f;
        for (int i = 1; i <= 20; i++) {
            temp = denominator;
            denominator = numerator;
            numerator = temp + denominator;
            sum += numerator / denominator;
        }
        System.out.println(sum);
    }
}
