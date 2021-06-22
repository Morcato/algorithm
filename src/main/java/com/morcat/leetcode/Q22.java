package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 *  @author shenzixing
 *  @since 2021-06-22
 */
public class Q22 {

    /**
     * 我的解法:回溯解法,递归得到结果
     */
    class MySolution {

        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            getResult(n, "", 0);
            return result;
        }

        public void getResult(int n, String s, int leftNums) {
            if (s.length() == n * 2) {
                result.add(s);
                return;
            }
            if (leftNums <= 0) {
                getResult(n, s + "(", leftNums + 1);
            } else if (n * 2 - s.length() - leftNums <= 0) {
                getResult(n, s + ")", leftNums - 1);
            } else {
                getResult(n, s + "(", leftNums + 1);
                getResult(n, s + ")", leftNums - 1);
            }
        }
    }

}
