package com.open.alg.category.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 20:05
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 */
public class 两个数组的交集 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (map.getOrDefault(nums2[i], 0) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
            int index = 0;
            int[] res = new int[list.size()];
            for (int k = 0; k < list.size(); k++) {
                res[index++] = list.get(k);
            }
            return res;
        }
    }
}
