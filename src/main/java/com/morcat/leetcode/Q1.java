package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Q1_两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 *  @author shenzixing
 *  @since 2021-02-02
 */
public class Q1 {

    /**
     * 我的解法,暴力枚举.双循环计算
     * 时间复杂度O(n²)
     */
    class Enum {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    /**
     * 使用hashmap记录每次遍历的值,每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 时间复杂度O(n)
     */
    class HashMao {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

}
