package com.morcat.leetcode;

/**
 * @author shenzixing
 * @date 2025/5/10
 */
public class Q209 {

    /**
     * 双指针解法
     * 时间复杂度O(n)
     * 使用了双指针法,解决此问题
     * 解决思路是定义两个指针slow和fast,fast指针每次向右移动一步,直到sum>=target,此时记录当前长度,然后slow指针向右移动一步,直到sum<target,重复上述过程.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int slowIndex = 0;
        int fastIndex = 0;
        int result = Integer.MAX_VALUE;
        int sum = nums[fastIndex];

        while (slowIndex < nums.length && fastIndex < nums.length) {
            if (sum >= target) {
                result = Math.min(result, fastIndex - slowIndex + 1);
                sum = sum - nums[slowIndex];
                slowIndex++;

            } else if (sum < target) {
                fastIndex++;
                if(fastIndex < nums.length){
                    sum = sum + nums[fastIndex];
                }

            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
