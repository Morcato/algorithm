package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *  Q226_翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *  @author shenzixing
 *  @since 2021-01-21
 */
public class Q226 {

    /**
     * 递归解法,本质其实是递归交换左右的节点
     */
    public TreeNode invertTree_recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree_recursion(root.left);
        invertTree_recursion(root.right);
        return root;
    }

}
