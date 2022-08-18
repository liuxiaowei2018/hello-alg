package com.open.alg.category.algorithm.string;

import java.util.Arrays;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 11:16
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 */
public class 有效的字母异位词 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) return false;
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            return Arrays.equals(chars1, chars2);
        }
    }
}
