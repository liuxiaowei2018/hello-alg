package com.open.alg.subject.title.solution;

/**
 * @author liuxiaowei
 * @date 2022年05月09日 14:45
 * @Description 替换空格
 */
public class Solution05 {

    public String replaceSpace1(String s) {
        return s.replace(" ","%20");
    }

    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
