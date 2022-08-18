package com.open.alg.category.algorithm.string;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 10:41
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 */
public class 反转字符串 {

    class Solution {
        public void reverseString(char[] s) {
            int length = s.length;
            char temp;
            for (int i = 0; i < length/2; i++) {
                temp = s[i];
                s[i] = s[length - 1 - i];
                s[length - 1 - i] = temp;
            }
        }
    }
}
