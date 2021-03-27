package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *  @author shenzixing
 *  @since 2021-03-26
 */
public class Q94 {

    /**
     * 深度遍历 递归解法
     */
    class dfsRecursionSolution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return result;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            result.add(root.val);
            dfs(root.right);
        }
    }

    /**
     * 迭代解法 利用栈
     */
    class IterationSolution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList();
            Stack<TreeNode> stack = new Stack();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;

            }
            return result;
        }

    }


}
