package com.open.alg.category.string;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 10:45
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 */
public class 整数反转 {

    class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                int t = x % 10;
                int newRex = res * 10 + 1;
                if ((newRex - t) / 10 != res) {
                    return 0;
                }
                res = newRex;
                x /= 10;
            }
            return res;
        }

        public int reverse2(int x) {
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            return (int) res == res ? (int) res : 0;
        }
    }
}
