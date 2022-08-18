package com.open.alg.category.algorithm.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 16:18
 * @Description 多数元素
 *
 * 摩尔投票法。时间复杂度 O(n)，空间复杂度 O(1)。
 */
public class 多数元素 {

    public static int majorityElement(int[] nums) {
        int cnt = 0, major = 0;
        for (int num : nums) {
            if (cnt == 0) {
                major = num;
                cnt = 1;
            } else {
                cnt += (major == num ? 1 : -1);
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 2, 8};
        int i = majorityElement(nums);
        System.out.println(i);
    }
}
