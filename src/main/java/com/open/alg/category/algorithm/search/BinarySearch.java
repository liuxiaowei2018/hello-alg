package com.open.alg.category.algorithm.search;

/**
 * @author liuxiaowei
 * @date 2021年11月29日 16:12
 * @Description 二分查找
 */
public class BinarySearch {

    boolean check(int x) {
        return true;
    }

    int search1(int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int search2(int left, int right) {
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
