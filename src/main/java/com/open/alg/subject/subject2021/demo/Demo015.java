package com.open.alg.subject.subject2021.demo;

/**
 * @author: 伟酱
 * @date 2020/7/10 14:20
 * 题目：有数字1、2、3、4，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
public class Demo015 {

    //暴力解
    public static void main(String[] args) {
        count();
    }

    private static void count() {
        int x, y, z;
        int count = 0;
        for (x = 1; x <= 4; x++) { //百位
            for (y = 1; y <= 4; y++) { //十位
                for (z = 1; z <= 4; z++) { //各位
                    if (x != y && y != z && x != z) {
                        count++;
                        System.out.println(x*100+y*10+z);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
