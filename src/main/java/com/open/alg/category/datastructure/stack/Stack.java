package com.open.alg.category.datastructure.stack;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 14:54
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
