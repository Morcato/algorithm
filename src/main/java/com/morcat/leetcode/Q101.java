package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  Q101_对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *  @author shenzixing
 *  @since 2021-01-19
 */
public class Q101 {

    /**
     * 递归解法
     * 镜像对称，就是左右两边相等，也就是左子树和右子树是相当的。
     * 要递归的比较左子树和右子树
     */
    class Recursion {

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode leftTree, TreeNode rightTree) {
            if (leftTree == null && rightTree == null) {
                return true;
            }
            if (leftTree == null || rightTree == null) {
                return false;
            }
            if (leftTree.val != rightTree.val) {
                return false;
            }
            return check(leftTree.left, rightTree.right) && check(leftTree.right, rightTree.left);

        }

    }

    /**
     * 迭代解法
     * 镜像对称，就是左右两边相等，也就是左子树和右子树是相当的。
     *
     * 首先从队列中拿出两个节点(left 和 right)比较
     * 将 left 的 left 节点和 right 的 right 节点放入队列
     * 将 left 的 right 节点和 right 的 left 节点放入队列
     * 时间复杂度是 O(n)O(n)，空间复杂度是 O(n)O(n)
     *
     */
    class Iteration {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);

            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);

                queue.add(left.right);
                queue.add(right.left);
            }
            return true;

        }

    }

}
