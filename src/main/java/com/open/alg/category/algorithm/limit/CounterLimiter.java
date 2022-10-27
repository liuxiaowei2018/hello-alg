package com.open.alg.category.algorithm.limit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxiaowei
 * @date 2022年10月27日 13:29
 * @Description 计数器限流
 * 在单位时间内累加访问次数，当访问次数达到设定的阈值时，触发限流策略，当进入下一个单位时间时访问次数清零
 * 缺点: 临界问题（突刺现象）
 */
@Slf4j
public class CounterLimiter {

    public long timeStamp = getNowTime();
    public int reqCount = 0;
    // 时间窗口内最大请求数
    public final int limit = 2;
    // 时间窗口ms
    public final long interval = 1000;

    /**
     * 假设限制每分钟请求量不超过100。方法是：设置一个计数器，当请求到达时如果计数器到达阈值，则拒绝请求，否则计数器加1；每分钟重置计数器为0
     *
     * @return boolean
     */
    public boolean grant() {
        long now = getNowTime();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            // 超时后重置
            timeStamp = now;
            reqCount = 1;
            return true;
        }
    }

    public long getNowTime() {
        return System.currentTimeMillis();
    }

}
