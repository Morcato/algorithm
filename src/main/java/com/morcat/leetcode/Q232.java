package com.morcat.leetcode;

import java.util.Stack;

/**
 * @author shenzixing
 * @date 2025/5/9
 */
public class Q232 {

    /**
     * 我的解法:使用两个栈,每当push一个元素,都往stack1中push,pop和peek操作时,都pop stack1中的元素,直到stack1中只有一个元素,pop或peek时,返回该元素,然后将stack2中的元素pop回stack1中.
     * 整体效率较低
     */
    class MySolution {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MySolution() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            int result;

            while (stack1.size() > 1) {
                int val = stack1.pop();
                stack2.push(val);
            }
            result = stack1.pop();

            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return result;

        }

        public int peek() {
            int result;

            while (stack1.size() > 1) {
                int val = stack1.pop();
                stack2.push(val);
            }
            result = stack1.pop();
            stack2.push(result);

            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return result;
        }

        public boolean empty() {

            return stack1.isEmpty();

        }
    }


}
