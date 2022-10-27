package com.open.alg.category.algorithm.datastructure.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 20:27
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 */
public class 加一 {

    static class Solution {
        public static int[] plusOne(int[] digits) {
            int length = digits.length;
            for (int i = length - 1; i >=0 ; i--) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits;
                } else {
                    //如果数组当前元素等于9，那么加1之后
                    //肯定会变为0，我们先让他变为0
                    digits[i] = 0;
                }
            }
            //除非数组中的元素都是9，否则不会走到这一步，
            //如果数组的元素都是9，我们只需要把数组的长度
            //增加1，并且把数组的第一个元素置为1即可
            int[] temp = new int[length + 1];
            temp[0] = 1;
            return temp;
        }
    }

    public static void main(String[] args) {
        int[] digits = {4,3,9,9};
        int[] ints = Solution.plusOne(digits);
        System.out.println(ints);

    }
}
