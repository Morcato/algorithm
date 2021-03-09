package com.morcat.leetcode;

/**
 *
 *  Q1047_删除字符串中的所有相邻重复项
 *
 *  给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *  
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 *  @author shenzixing
 *  @since 2021-03-09
 */
public class Q1047 {

    /**
     * 我的思路,使用递归的方式每次删除两个相同字母
     */
    class MySolution {
        public String removeDuplicates(String s) {
            if (s.length() < 2) {
                return s;
            }
            int index = 0;
            String temp = "";
            while (index + 1 < s.length()) {
                if (s.charAt(index) == s.charAt(index + 1)) {
                    temp = s.substring(0, index) + s.substring(index + 2);
                    break;
                }
                index++;
            }
            if (temp != "") {
                return removeDuplicates(temp);
            } else {
                return s;
            }

        }
    }

}
