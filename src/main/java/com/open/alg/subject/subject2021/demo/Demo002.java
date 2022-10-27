package com.open.alg.subject.subject2021.demo;

/**
 * @Package: com.lxw.algorithm.recursion
 * @ClassName: Demo02
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description: 递归法求阶乘
 */
public class Demo002 {

    public static void main(String[] args) {
        System.out.println(recursion(5));
    }

    /**
     * 求n！的值（n>=0）
     * @param n
     * @return
     */
    public static long recursion(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * recursion(n - 1);
        }
    }
}
