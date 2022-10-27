package com.open.alg.subject.subject2021.demo;

/**
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description: 递归累加求和
 */
public class Demo013 {

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }

    /**
     * 求 1+2+3+...+n
     * @param n
     * @return
     */
    public static long getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }
}
