package com.morcat.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 *  @author shenzixing
 *  @since 2021-03-10
 */
public class Q20 {

    /**
     * 我的解题思路:使用栈记录右半边括号,遇到右半边括号则弹出栈进行比对.如果不是一对则继续
     * 可以优化的点: List可以不用保存String,而是保存Character
     * List<Character> left = Arrays.asList('(', '{', '['); 注意:单引号!!!
     */
    class MySolution {
        public boolean isValid(String s) {
            List<String> left = Arrays.asList("(", "{", "[");
            List<String> right = Arrays.asList(")", "}", "]");
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                Character cc = s.charAt(i);
                if (left.contains(cc.toString())) {
                    stack.push(cc);
                } else if (right.contains(cc.toString())) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String leftValue = stack.pop().toString();
                    if (leftValue.equals("(") && !cc.toString().equals(")")) {
                        return false;
                    } else if (leftValue.equals("{") && !cc.toString().equals("}")) {
                        return false;
                    } else if (leftValue.equals("[") && !cc.toString().equals("]")) {
                        return false;
                    }
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }

        }


    }

}
