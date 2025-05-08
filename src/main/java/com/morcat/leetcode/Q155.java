package com.morcat.leetcode;

import java.util.Stack;

/**
 * Q155_最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
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
 * @author shenzixing
 * @since 2021-05-15
 */
public class Q155 {

    /**
     * 除了栈以外,额外保存一个最小值,每次pop时维护该最小值即可
     */
    class MinStack {

        Stack<Integer> stack = new Stack();
        Integer min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
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

    /**
     * 第二种解法:辅助栈解法,空间复杂度更低
     * <p>
     * 可以用辅助栈来存储每一步的最小值。这样每次push和pop都能O(1)更新最小值。
     */
    class MinStack_SubStack {

        private int min;

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                int minVal = minStack.peek();
                minStack.push(Math.min(val, minVal));
            }

        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
