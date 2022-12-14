package com.open.alg.category.algorithm.datastructure.array;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 9:41
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 */
public class 移动零 {

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //示例:
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]

    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }

    class Solution2 {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    index++;
                }
            }
        }
    }

}
