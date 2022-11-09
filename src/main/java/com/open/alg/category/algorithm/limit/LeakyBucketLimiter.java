package com.open.alg.category.algorithm.limit;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxiaowei
 * @date 2022年10月27日 13:37
 * @Description 漏桶算法
 * 请求就像水一样以任意速度注入漏桶，桶会按照固定的速度将水漏掉。当注入速度持续大于漏出的速度时，漏桶会变满，此时新进入的请求将会被丢弃
 */
@Data
public class LeakyBucketLimiter {

    /**
     * 上次请求到来的时间
     */
    private long preTime = System.currentTimeMillis();
    /**
     * 漏水速率,n/s
     */
    private int leakRate;
    /**
     * 储蓄桶容量
     */
    private int capacity;
    /**
     * 当前水量
     */
    private int water;

    public LeakyBucketLimiter(int leakRate, int capacity) {
        this.leakRate = leakRate;
        this.capacity = capacity;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();

        //先漏水,计算剩余水量
        water = Math.max(0, water - (int) ((now - preTime) / 1000) * leakRate);
        preTime = now;

        //桶未满
        if (water + 1 <= capacity) {
            water++;
            return true;
        }

        return false;
    }


}
