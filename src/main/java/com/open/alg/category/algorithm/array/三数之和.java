package com.open.alg.category.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年10月17日 13:27
 * @Description
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    // 算法流程：
    // 1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
    // 2.对数组进行排序。
    // 3.遍历排序后数组：
    //  若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
    //  对于重复元素：跳过，避免出现重复解
    //  令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
    //  当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
    //  若和大于 0，说明 nums[R] 太大，R 左移
    //  若和小于 0，说明 nums[L] 太小，L 右移
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        // 排序
        Arrays.sort(nums);
        // 双指针
        int len = nums.length;

        for (int i = 0; i < len; ++i) {
            int curr = nums[i];
            if (curr > 0) return lists;
            if (i > 0 && curr == nums[i - 1]) continue;

            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }


        }
        return lists;
    }
}
