package com.open.alg.category.algorithm.search;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 8:40
 */
public class MorrisTraversalSort {

    public static void process(Node head) {
        if(head == null) {
            return;
        }
        process(head.left);
        process(head.right);
    }


    public static class Node {
        public int value;
        Node left;
        Node right;
        public Node(int data) {
            this.value = data;
        }
    }

    //打印时机：向右走之前
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;//当前节点
        Node cur2 = null;//最右
        while (cur1 != null) {
            cur2 = cur1.left;
            //左孩子不为空
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }//找到最右
                //右指针为空，指向cur1，cur1向左继续
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }//右指针不为空，设为空
            }
            System.out.print(cur1.value + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    //打印时机（第一次遇到）：发现左子树最右的孩子右指针指向空，或无左子树。
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    //逆序打印所有右边界
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }
    //逆序打印
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }
    //逆序（类似链表逆序）
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
    }

}
