package com.open.alg.category.algorithm.limit;

import lombok.Data;

/**
 * @author liuxiaowei
 * @date 2022年10月27日 13:39
 * @Description 令牌桶算法
 * 以恒定速率向令牌桶发送令牌，请求到达时，尝试从令牌桶中拿令牌，只有拿到令牌才能够放行，否则将会被拒绝。
 * 令牌桶大小固定，如果令牌桶被填满，则会丢弃新生成的要放进来的令牌，如果桶内没有令牌则触发限流策略
 */
@Data
public class TokenBucketLimiter {

    /**
     * 上次请求到来的时间
     */
    private long preTime = System.currentTimeMillis();
    /**
     * 放入令牌速率,n/s
     */
    private int putRate;
    /**
     * 令牌桶容量
     */
    private int capacity;
    /**
     * 当前令牌数
     */
    private int bucket;

    public TokenBucketLimiter(int putRate, int capacity) {
        this.putRate = putRate;
        this.capacity = capacity;
    }

    public boolean limit() {
        long now = System.currentTimeMillis();

        //先放入令牌，再获取令牌
        bucket = Math.min(capacity, bucket + (int) ((now - preTime) / 1000) * putRate);
        preTime = now;

        if (bucket == 0) {
            return false;
        }

        bucket--;
        return true;
    }

}
