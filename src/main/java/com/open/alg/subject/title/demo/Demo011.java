package com.open.alg.subject.title.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2020/12/8
 * @Description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class Demo011 {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        //暴力枚举
        int[] ints = twoSum(nums, target);

        //哈希表
        ints = twoSum2(nums, target);
    }

    /**
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    /**
     * 暴力枚举
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

}
