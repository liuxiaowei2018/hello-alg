package com.open.alg.subject.title.solution;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liuxiaowei
 * @date 2022年05月09日 14:45
 * @Description 从尾到头打印链表
 */
public class Solution06 {

    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack  = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public int[] reversePrint2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size - i -1);
        }
        return array;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        ListNode newList = reverse(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        ListNode t1  = head.next;
        // 让 2 的 next 指向 1
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;
    }





    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
