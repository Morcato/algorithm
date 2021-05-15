package com.morcat.leetcode;

import java.util.Stack;

/**
 *
 *  Q155_最小栈
 *
 *  设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *  @author shenzixing
 *  @since 2021-05-15
 */
public class Q155 {

    /**
     * 除了栈以外,额外保存一个最小值,每次pop时维护该最小值即可
     */
    class MinStack {

        Stack<Integer> stack = new Stack();
        Integer min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            min = Math.min(val, min);
        }

        public void pop() {
            int val = stack.pop();
            if (val == min) {
                min = Integer.MAX_VALUE;
                refreshMin();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }

        public void refreshMin() {

            for (Integer i : stack) {
                min = Math.min(min, i);
            }
        }
    }

}
