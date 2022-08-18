package com.open.alg.category.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 11:03
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 */
public class 字符串中的第一个唯一字符 {

    static class Solution {
        public static int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap();
            HashSet<Character> characters = new HashSet<>();
            char[] chars = s.toCharArray();
            //先统计每个字符的数量
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(chars[i]) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int leetcode = Solution.firstUniqChar("letctode");
        System.out.println(leetcode);
    }
}
