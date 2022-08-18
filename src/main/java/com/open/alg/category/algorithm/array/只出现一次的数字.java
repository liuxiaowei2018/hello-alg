package com.open.alg.category.algorithm.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 19:56
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 */
public class 只出现一次的数字 {

    class Solution {
        public int singleNumber(int[] nums) {
            int reduce = 0;
            for (int i = 0; i < nums.length; i++) {
                reduce = nums[i] ^ reduce;
            }
            return reduce;
        }
    }
}
