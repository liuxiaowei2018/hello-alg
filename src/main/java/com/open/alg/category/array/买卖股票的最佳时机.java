package com.open.alg.category.array;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 18:25
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 */
public class 买卖股票的最佳时机 {

    //贪心算法
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length -1; i++) {
                if (prices[i] < prices[i + 1]) {
                    max += prices[i + 1] - prices[i];
                }
            }
            return max;
        }
    }
}
