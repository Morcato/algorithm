package com.morcat.leetcode;

/**
 *
 *  Q88_合并两个有序数组
 *
 *  给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 *  @author shenzixing
 *  @since 2021-04-05
 */
public class Q88 {

    /**
     * 思路:双指针法,两指针分别记录nums1,nums2数组的最小数字.填充至一个新数组中,再将新数组的数据填入nums1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int[] sort = new int[m + n];
        while (index1 < m || index2 < n) {
            int min;
            if (index1 >= m) {
                min = nums2[index2];
                index2++;
            } else if (index2 >= n) {
                min = nums1[index1];
                index1++;
            } else {
                if (nums1[index1] < nums2[index2]) {
                    min = nums1[index1];
                    index1++;
                } else {
                    min = nums2[index2];
                    index2++;
                }
            }
            sort[index2 + index1 - 1] = min;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
    }

}
