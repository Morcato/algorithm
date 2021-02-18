package com.morcat.leetcode;

/**
 *  Q34_在排序数组中查找元素的第一个和最后一个位置
 *
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 *  @author shenzixing
 *  @since 2021-02-18
 */
public class Q34 {

    /**
     * 思路:二分查找法,找到目标值后,从目标值开始寻找起始与结束值.
     */
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                start++;

                end = mid;
                while (end <= nums.length - 1 && nums[end] == target) {
                    end++;
                }
                end--;
                break;

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}
