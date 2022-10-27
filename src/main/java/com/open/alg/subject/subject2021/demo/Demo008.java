package com.open.alg.subject.subject2021.demo;

/**
 * @title: Demo008
 * @author: 伟酱
 * @date 2020/7/10 14:29
 * 判断101-200之间有多少个素数，并输出所有素数。
 */
public class Demo008 {

    // 质数只能被1或本身整除 可以用循环来做，循环的最大值是sqrt(本身)
    public static void main(String[] args) {
        int count=0;
        for (int i = 100; i <=200 ; i++) {
            if (isPrime(i)){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }

    /**
     * 判断一个数是不是质数
     * @param x
     * @return
     */
    public static boolean isPrime(int x){
        if (x == 1 || x == 0){
            return false;
        }
        for (int i = 2; i < Math.sqrt(x) ; i++) {
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
}
