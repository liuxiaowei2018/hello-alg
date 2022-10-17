package com.open.alg.category.algorithm.array;

/**
 * @author liuxiaowei
 * @date 2022年10月17日 13:13
 * @Description https://leetcode.cn/problems/container-with-most-water/
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    // 设两指针 ii , jj ，指向的水槽板高度分别为 h[i]h[i] , h[j]h[j] ，此状态下水槽面积为 S(i, j)S(i,j) 。由于可容纳水的高度由两板中的 短板 决定，
    // 因此可得如下面积公式:
    // S(i,j)=min(h[i],h[j])×(j−i)
    // 初始化双指针分列水槽左右两端，循环每轮将 短板 向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
    // 算法流程：
    //  初始化： 双指针 i , j 分列水槽左右两端；
    //  循环收窄： 直至双指针相遇时跳出；
    //  更新面积最大值 res ；
    //  选定两板高度中的短板，向中间收窄一格；
    //  返回值： 返回面积最大值 res 即可；

    public static int maxArea(int[] height) {
        int i = 0,j = height.length - 1,res = 0;
        while (i < j) {
            // 确定 i指针为短板 还是 j指针为短板
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }



}
