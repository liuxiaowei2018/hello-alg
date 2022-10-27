package com.open.alg.subject.subject2021.demo;

/**
 * @author: 伟酱
 * @date 2020/7/10 14:29
 * 题目:一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数
 * 请问该数是多少？
 */
public class Demo016 {

    // 分析: num为整数，sqrt(num+100) 它的向下取整 和 它本身是一致的 那就是一个完全平方数
    public static void main(String[] args) {
        int num = 1;
        while (num != 0) {
            num++;
            if (Math.floor(Math.sqrt(num + 100)) == Math.sqrt(num + 100) &&
                    Math.floor(Math.sqrt(num + 100)) == Math.sqrt(num + 100)) {
                System.out.println(num);
                break;
            }
        }
    }
}
