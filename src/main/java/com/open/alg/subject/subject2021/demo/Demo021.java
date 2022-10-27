package com.open.alg.subject.subject2021.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuxiaowei
 * @date 2022年05月09日 14:35
 * @Description 数组中重复的数字
 */
public class Demo021 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

}
