package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Q104_二叉树的最大深度
 *
 *  给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  @author shenzixing
 *  @since 2021-01-18
 */
public class Q104 {

    /**
     * 递归解法(其实是基于DFS的前序遍历)
     */
    public int maxDepth_recursion(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth_recursion(root.left);
            int rightDepth = maxDepth_recursion(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * 广度优先遍历解法
     *
     * 不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
     * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，
     * 最后我们用一个变量 count 来维护拓展的次数，该二叉树的最大深度即为count。
     *
     */
    public int maxDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }

}
