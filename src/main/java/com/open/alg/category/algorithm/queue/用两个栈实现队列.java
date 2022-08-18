package com.open.alg.category.algorithm.queue;

import java.util.LinkedList;

/**
 * @author liuxiaowei
 * @date 2021年11月30日 13:08
 * @Description https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5d3i87/
 */
public class 用两个栈实现队列 {

    class CQueue {
        LinkedList<Integer> A, B;

        public CQueue() {
            A = new LinkedList<Integer>();
            B = new LinkedList<Integer>();
        }

        /**
         * 加入队尾
         *
         * @param value
         */
        public void appendTail(int value) {
            A.addLast(value);
        }

        /**
         * 删除队首
         *
         * @return
         */
        public int deleteHead() {
            if(!B.isEmpty()) return B.removeLast();
            if(A.isEmpty()) return -1;
            while(!A.isEmpty())
                B.addLast(A.removeLast());
            return B.removeLast();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
