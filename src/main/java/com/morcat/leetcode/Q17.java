package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author shenzixing
 *  @since 2021-06-22
 */
public class Q17 {


    /**
     * 我的解法:回溯法
     */
    class MySolution {

        private List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList();
            }
            dfs("", digits);
            return result;
        }

        private void dfs(String s, String digits) {
            int index = s.length();
            if (s.length() == digits.length()) {
                result.add(s);
                return;
            }
            Character digit = digits.charAt(index);
            switch (digit) {
                case '2': {
                    dfs(s + "a", digits);
                    dfs(s + "b", digits);
                    dfs(s + "c", digits);
                    break;
                }
                case '3': {
                    dfs(s + "d", digits);
                    dfs(s + "e", digits);
                    dfs(s + "f", digits);
                    break;
                }
                case '4': {
                    dfs(s + "g", digits);
                    dfs(s + "h", digits);
                    dfs(s + "i", digits);
                    break;
                }
                case '5': {
                    dfs(s + "j", digits);
                    dfs(s + "k", digits);
                    dfs(s + "l", digits);
                    break;
                }
                case '6': {
                    dfs(s + "m", digits);
                    dfs(s + "n", digits);
                    dfs(s + "o", digits);
                    break;
                }
                case '7': {
                    dfs(s + "p", digits);
                    dfs(s + "q", digits);
                    dfs(s + "r", digits);
                    dfs(s + "s", digits);
                    break;
                }
                case '8': {
                    dfs(s + "t", digits);
                    dfs(s + "u", digits);
                    dfs(s + "v", digits);
                    break;
                }
                case '9': {
                    dfs(s + "w", digits);
                    dfs(s + "x", digits);
                    dfs(s + "y", digits);
                    dfs(s + "z", digits);
                    break;
                }
            }

        }

    }

}
