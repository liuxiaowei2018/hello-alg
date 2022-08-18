package com.open.alg.category.datastructure.map;

import java.util.Set;

/**
 * @author liuxiaowei
 * @date 2022年04月02日 15:17
 * @Description
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> m = new HashMap<>();
        m.put("key", "1111");
        m.put("key2", "2222");
        m.put("key3", "3333");
        m.put("key4", "4444");
        System.out.println("---------------");
        System.out.println(m.get("key1"));
        System.out.println(m.get("key"));
        System.out.println("--------------- keySet");
        Set<String> strings = m.keySet();
        for (String s : strings) {
            System.out.println(s + ":" + m.get(s));
        }
        System.out.println("--------------- remove");
        m.remove("key");
        strings = m.keySet();
        for (String s : strings) {
            System.out.println(s + ":" + m.get(s));
        }
        System.out.println("--------------- clear");
        m.clear();
        strings = m.keySet();
        for (String s : strings) {
            System.out.println(s + ":" + m.get(s));
        }
    }
}
