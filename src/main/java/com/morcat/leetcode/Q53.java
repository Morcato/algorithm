package com.morcat.leetcode;

/**
 *
 * Q53_最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *  @author shenzixing
 *  @since 2021-01-23
 */
public class Q53 {

    /**
     *  双循环遍历,效率很低
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
