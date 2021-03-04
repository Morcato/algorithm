package com.morcat.leetcode;

/**
 *
 *  @author shenzixing
 *  @since 2021-03-04
 */
public class Q424 {

    /**
     * 我的解题方式:
     * 使用滑动窗口,以26个字母的每个字母进行遍历,判断能否全替换成该字母
     */
    class MySolution {
        int result = 0;

        public int characterReplacement(String s, int k) {
            int max = 0;
            for (char i = 'A'; i <= 'Z'; i++) {
                window(i, s, k);
            }
            return result;
        }

        public void window(Character cc, String s, int k) {
            int left = 0;
            int right = 0;
            int ccCount = 0;
            int otherCount = 0;
            while (right < s.length()) {
                if (s.charAt(right) == cc) {
                    ccCount++;
                } else {
                    otherCount++;
                }
                right++;
                if (otherCount <= k) {
                    result = Math.max(otherCount + ccCount, result);
                }
                while (otherCount > k) {
                    if (s.charAt(left) == cc) {
                        ccCount--;
                    } else {
                        otherCount--;
                    }

                    left++;
                }
            }
        }
    }

}
