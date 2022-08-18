package com.open.alg.category.datastructure.linkedlist;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2020/12/9
 * @Description: 链表节点
 */
@Data
public class ListNode {

    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.value = val;
    }

    public ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }
}
