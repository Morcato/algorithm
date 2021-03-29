package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.*;

/**
 *
 * Q145_二叉树的后续遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *  @author shenzixing
 *  @since 2021-03-29
 */
public class Q145 {

    /**
     * 迭代解法
     * 思路: 由于后续遍历为 左->右->中
     * 因此我们需要记录从栈中弹出的数据究竟是否已经被识别过.此处使用了Set来记录
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> mark = new HashSet<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (mark.contains(node) || node.right == null) {
                result.add(node.val);
            } else {
                stack.add(node);
                mark.add(node);
                root = node.right;
            }
        }
        return result;
    }

}
