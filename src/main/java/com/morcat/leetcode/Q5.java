package com.morcat.leetcode;

/**
 *
 *  Q5_最长回文子串
 *
 *  给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 *  @author shenzixing
 *  @since 2021-03-07
 */
public class Q5 {

    /**
     * 中心扩展法:
     * 1.遍历字符串的每个值
     * 2.每个值向两边拓展,发现不相同或者达到边界则停止最终返回回文串
     * 3.最终判断哪个回文串最长就是最长回文串
     */
    class CenterExtension {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                String max1 = getMax(s, i);
                String max2 = "";
                if (i + 1 < s.length()) {
                    max2 = getMax(s, i, i + 1);
                }
                String max = max1.length() > max2.length() ? max1 : max2;
                if (max.length() > result.length()) {
                    result = max;
                }
            }
            return result;
        }

        public String getMax(String s, int index) {
            int left = index - 1;
            int right = index + 1;
            String max = s.substring(index, index + 1);
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                max = s.substring(left, right + 1);
                left--;
                right++;
            }
            return max;
        }

        public String getMax(String s, int leftIndex, int rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return "";
            }
            String max = s.substring(leftIndex, rightIndex + 1);
            int left = leftIndex - 1;
            int right = rightIndex + 1;

            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                max = s.substring(left, right + 1);
                left--;
                right++;
            }
            return max;
        }

    }
}
