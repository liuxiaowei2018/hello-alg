package com.open.alg.category.datastructure.linkedlist;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 15:19
 */
public class LinkedListTest {

    public static void main(String[] args) {
        //testStack();
    }

    private static void testStack() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
    }

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.getValue() == val){
            ListNode delNode = head;
            head = head.getNext();
            delNode.setNext(null);
        }
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        while(prev.getNext() != null){
            if(prev.getNext().getValue() == val) {

                ListNode delNode = prev.getNext();
                prev.setNext(delNode.getNext());
                delNode.setNext(null);
            }
            else {
                prev = prev.getNext();
            }
        }
        return head;
    }
}

