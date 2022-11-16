package com.open.alg.subject.subject2021.demo;

/**
 * @author liuxiaowei
 * @date 2022年05月09日 14:45
 * @Description
 */
public class Demo025 {


    public static void main(String[] args) {
        String str = "test case";
        String result = getCase(str);
        System.out.println(result);
    }

    private static String getCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                result.append(str.charAt(i));
                continue;
            }
            result.append(str.charAt(i)).append(" ");
        }
        return result.toString();
    }
}
