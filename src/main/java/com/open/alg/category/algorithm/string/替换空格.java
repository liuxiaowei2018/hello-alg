package com.open.alg.category.algorithm.string;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 12:57
 * @Description https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
 */
public class 替换空格 {

    class Solution {
        public String replaceSpace(String s) {
            return s.replace(" ","%20");
        }
    }
}
