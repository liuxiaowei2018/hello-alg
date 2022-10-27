package com.open.alg.subject.subject2021.demo;

/**
 * @title: Demo020
 * @author: 伟酱
 * @date 2020/7/10 14:01
 * 题目：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
public class Demo020 {

    //记录当前的答案candidate ，记录count。
    //这时，我们遍历了一个新的数字，如果和candidate 一样，我们就让count+1，否则让count-1.
    //如果count变成了0，那candidate 就下擂台，换新的擂主（数字）上，
    //也就是说把candidate 更新成新的数字，count也更新成1.
    //最后在擂台上的一定是答案。
    public int majorityElement(int[] nums) {

        int count = 0;//当前答案出现的次数
        Integer candidate = null;//答案

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
