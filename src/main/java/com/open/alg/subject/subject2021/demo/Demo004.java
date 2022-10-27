package com.open.alg.subject.subject2021.demo;

/**
 * @Package: com.lxw.algorithm.recursion
 * @ClassName: Demo04
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description:
 */
/*
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下 的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 */
public class Demo004 {
    // 逆向解题 递归思想
    // 第10天剩下了1个，说明第九天吃之前的是（（第 9 + 1 的数量）+1）*2
    // 第八天吃之前的是（（第8 +1的数量）+1）*2
    // 找到了规律，可以进行递归
    public static int total(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (total(day + 1) + 1) * 2;
        }

    }

    public static void main(String[] args) {
        System.out.println(total(1));
    }
}
