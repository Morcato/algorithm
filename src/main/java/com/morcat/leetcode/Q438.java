package com.morcat.leetcode;

import java.util.*;

/**
 *
 * Q438_找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 *  @author shenzixing
 *  @since 2021-02-26
 */
public class Q438 {

    /**
     * 我的解题:
     * 思路为 滑动窗口
     * 使用两个map判断字母是否异位
     */
    class MySolution {
        private Map<Character, Integer> sourceMap = new HashMap();
        private Map<Character, Integer> targetMap = new HashMap();

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < p.length(); i++) {
                targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
            }
            int left = 0;
            int right = 0;
            String temp = "";
            while (right < s.length()) {
                sourceMap.put(s.charAt(right), sourceMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                while ((right - left) >= p.length()) {
                    if (isSuitable()) {
                        result.add(left);
                    }
                    int value = sourceMap.get(s.charAt(left));
                    if (value == 1) {
                        sourceMap.remove(s.charAt(left));
                    } else {
                        sourceMap.put(s.charAt(left), value - 1);
                    }
                    left++;
                }
            }
            return result;
        }

        private Boolean isSuitable() {
            Set<Character> set = targetMap.keySet();
            for (Character c : set) {

                if (!sourceMap.getOrDefault(c, 0).equals(targetMap.getOrDefault(c, 0))) {
                    return false;
                }
            }
            return true;
        }
    }

}
