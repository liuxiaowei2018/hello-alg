package com.open.alg.subject.subject2021.demo;

/**
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description: 递归求斐波那契数列
 */

public class Demo018 {

    // 格式为：1、1、2、3、5、8、13、21、34、....
    // 分析得到斐波那契数列的第n项是(n-1)+(n-2)的和
    // 使用公式f[n]=f[n-1]+f[n-2]，依次递归计算，递归结束条件是f[1]=1，f[2]=1。
    public static long isN(long n) {
        if (1 == n || 2 == n) {
            return 1;
        }
        return isN(n - 1) + isN(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(isN(50));
    }
}
