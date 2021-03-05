package com.morcat.leetcode;

/**
 *
 * Q42_接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 *  @author shenzixing
 *  @since 2021-03-05
 */
public class Q42 {

    /**
     * 暴力解法
     * 遍历数组,获取每个数 往左与往右最大的数字,取最小值,就是这个数能承载的雨滴数. 相加即可
     */
    class ViolenceSolution {
        public int trap(int[] height) {
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result = result + getMax(height, i);
            }
            return result;
        }

        public int getMax(int[] height, int index) {
            int maxLeft = getMaxLeftHeight(height, index);
            int maxRight = getMaxRightHeight(height, index);
            int max = Math.min(maxLeft, maxRight);
            if (max > height[index]) {
                return max - height[index];
            } else {
                return 0;
            }
        }

        public int getMaxLeftHeight(int[] height, int index) {
            int max = 0;
            for (int i = index - 1; i >= 0; i--) {
                max = Math.max(max, height[i]);
            }
            return max;
        }

        public int getMaxRightHeight(int[] height, int index) {
            int max = 0;
            for (int i = index + 1; i < height.length; i++) {
                max = Math.max(max, height[i]);
            }
            return max;
        }
    }

    /**
     * 双指针法
     * 由双指针边走边计算,分别记录下左右两边的最大值.
     */
    class TwoPoints {
        public int trap(int[] height) {
            int result = 0;
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax < rightMax) {
                    if (leftMax > height[left]) {
                        result = leftMax - height[left] + result;

                    }
                    left++;
                } else {
                    if (rightMax > height[right]) {
                        result = rightMax - height[right] + result;

                    }
                    right--;
                }
            }
            return result;
        }
    }

}
