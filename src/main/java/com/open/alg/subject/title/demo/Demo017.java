package com.open.alg.subject.title.demo;

import java.io.File;

/**
 * @Author: liuxiaowei
 * @CreateTime: 2020/8/17
 * @Description: 递归打印多级目录
 */

public class Demo017 {

    public static void main(String[] args) {
        File dir = new File("D:\\Typora");
        list(dir);
    }
    public static void list(File file) {
        File[] listFiles = file.listFiles();
        for (File file1 : listFiles) {
            // 如果为文件夹，继续调用该方法
            if (file1.isDirectory()) {
                list(file1);
            }
            System.out.println(file1);
        }
    }
}
