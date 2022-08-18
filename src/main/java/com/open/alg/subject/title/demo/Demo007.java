package com.open.alg.subject.title.demo;

/**
 * @title: Demo007
 * @author: 伟酱
 * @date 2020/7/10 14:29
 * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 */
public class Demo007 {

    public static void main(String[] args) {
        System.out.println(count(1));
    }

    public static int count(int day){
        if(day == 10) {
            return 1;
        }
        return (count(day+1)+1)*2;
    }
}
