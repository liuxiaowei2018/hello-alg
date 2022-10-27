package com.open.alg.category.algorithm.datastructure.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 18:41
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 */
public class 旋转数组 {

    //临时数组

    class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            int[] temp = new int[length];
            // copy数组
            for (int i = 0; i < length; i++) {
                temp[i] = nums[i];
            }
            // 放回元素
            for (int i = 0; i < length; i++) {
                nums[(i + k) % length] = temp[i];
            }
        }
    }
}
