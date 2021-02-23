package com.morcat.leetcode;

import java.util.HashSet;

/**
 *  Q3_无重复字符的最长子串
 *
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 *  @author shenzixing
 *  @since 2021-02-23
 */
public class Q3 {

    /**
     * 滑动窗口解法
     * 找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet();
        int left = 0;
        int right = -1;
        while (left <= s.length() - 1) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 <= s.length() - 1 && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, set.size());
            left++;
        }
        return result;

    }

}
