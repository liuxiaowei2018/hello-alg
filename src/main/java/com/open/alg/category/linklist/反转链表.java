package com.open.alg.category.linklist;

/**
 * @author liuxiaowei
 * @date 2022年03月26日 20:48
 * @Description
 * 1 <- 3 <- 5 <- 7 <- 9  转换为 1 <- 3 <- 5 <- 7 <- 9
 * 现在有一个单链表，尝试将其所有节点倒序排列
 */
public class 反转链表 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);

        head = reverse(head);

        while (head != null){
            System.out.println(head.value+" ");
            head = head.next;
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverse(Node head) {
       //递归深度
        if (head.next == null) return head;

        //递归条件
        Node newHead = reverse(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
