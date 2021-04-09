package com.morcat.leetcode;

/**
 *
 * Q4_寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  @author shenzixing
 *  @since 2021-04-09
 */
public class Q4 {

    /**
     * 我的思路:双指针法. 在每个数组上各设置一个指针,寻找第X个数据.
     */
    class MySolution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sumLen = nums1.length + nums2.length;
            if (sumLen % 2 == 0) {
                int v1 = getValue(nums1, nums2, sumLen / 2);
                int v2 = getValue(nums1, nums2, sumLen / 2 - 1);
                return (v1 + v2) / 2D;
            } else {
                int v1 = getValue(nums1, nums2, sumLen / 2);
                return v1;
            }
        }

        public int getValue(int[] nums1, int[] nums2, int index) {
            int index1 = 0;
            int index2 = 0;
            int count = 0;
            while (index1 < nums1.length || index2 < nums2.length) {
                int value;
                if (index1 >= nums1.length) {
                    value = nums2[index2];
                    index2++;
                } else if (index2 >= nums2.length) {
                    value = nums1[index1];
                    index1++;
                } else {
                    if (nums1[index1] < nums2[index2]) {
                        value = nums1[index1];
                        index1++;
                    } else {
                        value = nums2[index2];
                        index2++;
                    }
                }
                if (index == count) {
                    return value;
                }
                count++;
            }
            return -1;
        }
    }

}
