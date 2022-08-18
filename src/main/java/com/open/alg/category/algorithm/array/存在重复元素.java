package com.open.alg.category.algorithm.array;

import java.util.HashSet;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 18:50
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 */
public class 存在重复元素 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> contains = new HashSet<>();
            for (int num : nums) {
                if (!contains.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }
}
