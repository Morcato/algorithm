package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Q239_滑动窗口最大值
 *
 *  给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 *  @author shenzixing
 *  @since 2021-03-03
 */
public class Q239 {

    /**
     * 我的解题思路:滑动窗口,每滑动一次计算一次最大值.
     * 但是数据量大时会超时
     */
    class MySolution_slideWindow {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int start = 0;
            int end = 0;
            List<Integer> windows = new ArrayList<>();
            List<Integer> result = new ArrayList();
            while (end < nums.length) {
                windows.add(nums[end]);
                end++;
                while (windows.size() == k) {
                    result.add(getMax(windows));

                    windows.remove(0);
                    start++;
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private Integer getMax(List<Integer> list) {
            Integer max = Integer.MIN_VALUE;
            for (Integer i : list) {
                max = Math.max(max, i);
            }
            return max;
        }
    }

}
