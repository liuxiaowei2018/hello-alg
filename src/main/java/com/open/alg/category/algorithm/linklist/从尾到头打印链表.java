package com.open.alg.category.algorithm.linklist;

import java.util.LinkedList;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 13:01
 * @Description https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dt66m/
 */
public class 从尾到头打印链表 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<>();
            while (head != null) {
                stack.add(head.val);
                head = head.next;
            }
            int[] result = new int[stack.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = stack.removeLast();
            }
            return result;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
