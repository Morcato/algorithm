package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Q169_多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  @author shenzixing
 *  @since 2021-01-04
 */
public class Q169 {

    /**
     * 哈希表做法:使用哈希映射（HashMap）来存储每个元素以及出现的次数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int majorityElement_hash(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer value = numsMap.getOrDefault(num, 0);
            numsMap.put(num, ++value);
        }

        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 摩尔投票法:如果一个数组里存在一个数超过一半，那么同时删去两个不同的数，超过一半的数仍然超过一半。
     * 找到超过一半的数，就是扫描数组，每次都删去两个不同的数，最后没有不同的了，剩下的就是超过一半的数。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int majorityElement_moore(int[] nums) {
        // 候选人
        int cadidate = 0;
        // 候选人出现次数
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                cadidate = num;
            }
            count = (cadidate == num) ? ++count : --count;

        }
        return cadidate;

    }


}
