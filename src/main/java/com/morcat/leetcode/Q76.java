package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Q76_最小覆盖子串
 * <p>
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * @author shenzixing
 * @since 2021-03-03
 */
public class Q76 {

    class SolutionV1 {
        /**
         * 滑动窗口解决
         */
        public String minWindow(String s, String t) {
            Map<Character, Integer> needsMap = new HashMap<>();
            Map<Character, Integer> windowsMap = new HashMap();
            for (int i = 0; i < t.length(); i++) {
                needsMap.put(t.charAt(i), needsMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            int left = 0;
            int right = 0;
            String result = "";
            while (right < s.length()) {
                windowsMap.put(s.charAt(right), windowsMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                while (contains(needsMap, windowsMap)) {
                    // 注意此处截取为左闭右开，由于上面right++了，因此可以直接使用right
                    String temp = s.substring(left, right);
                    if (result == "" || temp.length() < result.length()) {
                        result = temp;
                    }

                    windowsMap.put(s.charAt(left), windowsMap.get(s.charAt(left)) - 1);
                    left++;
                }

            }
            return result;

        }
    }

    public boolean contains(Map<Character, Integer> needsMap, Map<Character, Integer> windowsMap) {
        Set<Character> set = needsMap.keySet();
        for (Character c : set) {
            if (windowsMap.getOrDefault(c, 0) < needsMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2023.3.8 参考:https://labuladong.online/algo/essential-technique/sliding-window-framework/ 使用滑动窗口解决
     */
    class SolutionV2 {
        public String minWindow(String s, String t) {
            Map<Character, Integer> windows = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            int minLength = Integer.MAX_VALUE;
            int index = 0;
            for (Character c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                windows.put(s.charAt(right), windows.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                while (contains(need, windows)) {
                    int length = right - left;
                    if (length < minLength) {
                        minLength = length;
                        index = left;
                    }
                    windows.put(s.charAt(left), windows.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
            }
            if (minLength == Integer.MAX_VALUE) {
                return "";
            } else {
                return s.substring(index, index + minLength);
            }

        }

        private Boolean contains(Map<Character, Integer> need, Map<Character, Integer> windows) {
            for (Character c : need.keySet()) {
                if (need.get(c) > windows.getOrDefault(c, 0)) {
                    return false;
                }
            }
            return true;
        }
    }

}
