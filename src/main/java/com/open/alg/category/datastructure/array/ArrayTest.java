package com.open.alg.category.datastructure.array;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 14:42
 */
public class ArrayTest {

    public static void main(String[] args) {

        Array arr = new Array(20);
        for(int i = 0 ; i < 10 ; i ++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
