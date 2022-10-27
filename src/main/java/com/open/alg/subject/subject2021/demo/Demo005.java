package com.open.alg.subject.subject2021.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title: Demo005
 * @author: 伟酱
 * @date 2020/7/10 14:44
 * 题目:输入某年某月某日，判断这一天是这一年的第几天？
 */
public class Demo005 {
    public static void main(String[] args) throws IOException {
        //1.获取输入的字符串并解析为对应的年月日
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        // 2.判断是闰年还是非闰年
        // 闰年2月29天，非闰年2月28天
        // 设置好2月的天数
        int twoMonth = 28;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            twoMonth = 29;
        }
    }
}
