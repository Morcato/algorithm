package com.morcat.leetcode;

/**
 *
 *  Q14_最长公共前缀
 *
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 *  @author shenzixing
 *  @since 2021-05-11
 */
public class Q14 {

    /**
     * 多次遍历数组,每次比较第n个值是否相等
     */
    class MySolution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int index = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                if (isEquals(strs, index)) {
                    index++;
                } else {
                    break;
                }
            }
            if (index == 0) {
                return "";
            } else {
                return strs[0].substring(0, index);
            }

        }

        public boolean isEquals(String[] strs, int index) {
            Character c = null;
            for (String s : strs) {
                if (c == null) {
                    c = s.charAt(index);
                } else {
                    if (index >= s.length() || c != s.charAt(index)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
