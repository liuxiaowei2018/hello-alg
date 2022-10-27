package com.open.alg.category.algorithm.datastructure.array;

import java.util.HashMap;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 9:54
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 */
public class 两数之和 {

    static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //检查指针对应的值
                if (map.get(target - nums[i]) != null) {
                    // map(当前指针,上次存储的指针)
                    return new int[]{map.get(target-nums[i]),i};
                }
                //放入当前指针
                map.put(nums[i], i);
            }
            return new int[]{0, 0};
        }
    }

    public static void main(String[] args) {
        int[] digits = {4,3,9,9};
        int[] ints = Solution.twoSum(digits,12);
        System.out.println(ints);

    }
}
