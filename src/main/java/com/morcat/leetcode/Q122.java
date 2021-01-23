package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 * Q122_路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *  @author shenzixing
 *  @since 2021-01-21
 */
public class Q122 {

    /**
     * 递归解法
     */
    class Recursion {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            return hasSum(root, 0, targetSum);
        }

        private boolean hasSum(TreeNode node, int sum, int targetSum) {
            if (node == null) {
                return false;
            }
            if (node.left == null && node.right == null) {
                return sum + node.val == targetSum;
            }
            return hasSum(node.left, sum + node.val, targetSum)
                    || hasSum(node.right, sum + node.val, targetSum);

        }
    }

}
