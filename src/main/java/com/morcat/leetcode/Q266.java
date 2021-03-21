package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Q266_回文排列
 *
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 *
 * 示例 1：
 *
 * 输入: "code"
 * 输出: false
 * 示例 2：
 *
 * 输入: "aab"
 * 输出: true
 * 示例 3：
 *
 * 输入: "carerac"
 * 输出: true
 *
 *  @author shenzixing
 *  @since 2021-03-21
 */
public class Q266 {

    /**
     * 思路:使用hashmap统计每个字符出现次数,判断次数为奇数的数量不能超过1次.
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer i : map.values()) {
            if (i % 2 == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
