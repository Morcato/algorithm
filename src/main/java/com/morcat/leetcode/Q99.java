package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *  Q99_恢复二叉搜索树
 *
 *  给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 *
 *  @author shenzixing
 *  @since 2021-01-27
 */
public class Q99 {

    /**
     * 递归解法,参考第98题,使用中序遍历.
     * 如果 当前节点的值，小于 上一个节点的值，这就找到了需要交换的节点。利用这种方式，就不需要额外的数组空间了。
     *
     * TODO 虽然只用了常数个变量，但是递归调用仍然是需要额外空间的.想要真正的O(n)空间复杂度就要考虑(morris)莫里斯遍历了
     */
    class Recursion {

        private TreeNode pre = null;

        public TreeNode swapNode1 = null;
        public TreeNode swapNode2 = null;

        public void recoverTree(TreeNode root) {
            handle(root);
            int temp = swapNode1.val;
            swapNode1.val = swapNode2.val;
            swapNode2.val = temp;
        }

        public void handle(TreeNode root) {
            if (root == null) {
                return;
            }
            handle(root.left);

            if (pre == null) {
                pre = root;
            } else {

                if (root.val <= pre.val) {
                    if (swapNode1 == null) {
                        swapNode1 = pre;
                        swapNode2 = root;
                    } else {
                        swapNode2 = root;
                    }
                }
            }
            pre = root;

            handle(root.right);

        }
    }

}
