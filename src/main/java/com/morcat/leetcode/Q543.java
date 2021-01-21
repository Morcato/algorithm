package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *  Q543_二叉树的直径
 *  @author shenzixing
 *  @since 2021-01-21
 */
public class Q543 {


    int max = 0;

    /**
     * 递归解法
     * 遍历每一个节点，以每一个节点为中心点计算最大深度（左子树边长+右子树边长），更新全局变量max。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
