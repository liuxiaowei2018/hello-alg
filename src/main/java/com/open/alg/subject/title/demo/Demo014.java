package com.open.alg.subject.title.demo;

/**
 * @author: 伟酱
 * @date 2020/7/10 14:12
 * 题目: 球从100米高度自由落下，每次落地后反跳回原高度的一半；
 *      再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Demo014 {

    // 分析:每次反弹是前一次的1/2
    public static void main(String[] args) {
        double sum = 0;
        double initialMeter = 100;
        count(sum, initialMeter);
    }

    private static void count(double sum, double initialMeter) {
        for (int i = 1; i <=10 ; i++) {
            sum+=initialMeter;
            initialMeter/=2;
        }
        System.out.println("第十次的高度:"+initialMeter);
        System.out.println("第十次的总米数:"+sum);
    }
}
