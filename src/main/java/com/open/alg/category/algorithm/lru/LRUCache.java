package com.open.alg.category.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2022年11月14日 12:14
 * @Description
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        // 当该参数为 true 时则按照元素最后访问时间在双向链表中排序
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    /**
     * map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
     *
     * @param eldest
     * @return boolean
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean result = size() > CACHE_SIZE;
        if (result) {
            System.out.println("removeEldestEntry清除边界 清除缓存：" + eldest.getKey());
        } else {
            System.out.println("removeEldestEntry 不清除边界 ");
        }
        return result;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");

        System.out.println("**********************************************************");

        System.out.println("初始：1,2,3,4,5");
        System.out.println("访问2：");
        cache.get("2");
        System.out.println("访问2、3：");
        cache.get("2");
        cache.get("3");

        System.out.println("**********************************************************");

        for (String k : cache.keySet()) {
            System.out.println("*****" + k + "******");
        }
        System.out.println("增加数据6和7：");
        cache.put("6", "6");
        cache.put("7", "7");
        for (String k : cache.keySet()) {
            System.out.println("*****" + k + "******");
        }
    }


}
