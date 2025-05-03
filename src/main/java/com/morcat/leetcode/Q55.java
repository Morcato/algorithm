package com.morcat.leetcode;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 *
 * @author shenzixing
 * @date 2025/5/4
 */
public class Q55 {

    /**
     * “维护最远可达位置”贪心解法
     * <p>
     * 每一步都维护一个“目前为止能跳到的最远位置”，遍历数组时不断更新这个最远位置。
     * 如果你遍历到某个位置时，发现这个位置已经超过了你能到达的最远位置，说明你根本到不了这里，也就到不了终点，直接返回 false。
     * 如果你在遍历过程中，最远可达位置已经覆盖或超过了终点，说明一定能到达终点，直接返回 true。
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(nums[i] + i, maxReach);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
