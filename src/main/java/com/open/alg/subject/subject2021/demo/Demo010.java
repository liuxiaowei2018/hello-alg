package com.open.alg.subject.subject2021.demo;

/**
 * @title: Demo010
 * @author: 伟酱
 * @date 2020/7/10 14:29
 *  求100之内的素数
 */
public class Demo010 {

    public static void main(String[] args) {
        sign:for (int i = 2; i <=100 ; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j == 0) {
                    continue sign;
                }
            }
            System.out.println("质数:"+i);
        }
    }
}
