package com.open.alg.subject.title.demo;

/**
 * @title: Demo019
 * @author: 伟酱
 * @date 2020/7/10 14:01
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 */
public class Demo019 {

    //数字和自己异或，都等于0.
    //数字和0异或，都等于它本身，
    //异或又符合交换律
    //所以全部异或一遍，答案就是那个出现一次的数字。
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
