package com.open.alg.category.algorithm.datastructure.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 18:15
 * @Description 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class 删除排序数组中的重复项 {

    //循环：i=0，j=1，如果 i 的值不等于 j 的值，那么 i 向后移动一位，并且将 j 的值赋值给 i
    //最后的个数为i+1

    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
