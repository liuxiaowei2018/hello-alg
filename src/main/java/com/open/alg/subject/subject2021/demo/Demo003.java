package com.open.alg.subject.subject2021.demo;

/**
 * @Package: com.lxw.algorithm.recursion
 * @ClassName: Demo03
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description:  题目：有5个人坐在一起，问第五个人多少岁？
 * 他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。 问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
 *
 */
public class Demo003 {
    public static int getAge(int n) {
        if (n == 1) {
            return 10;
        }
        return getAge(n - 1) + 2;
    }

    public static void main(String[] args) {
        System.out.println(getAge(5));
    }
}
