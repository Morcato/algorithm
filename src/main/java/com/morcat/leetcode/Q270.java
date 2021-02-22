package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *
 *  Q270_最接近的二叉搜索树值
 *
 *  给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: 4
 *
 *  @author shenzixing
 *  @since 2021-02-22
 */
public class Q270 {

    /**
     * 二分查找法:
     * 如目标值小于当前根值，则向左搜索，否则向右搜索。在每一个步骤中选择最接近的值。
     */
    public int closestValue(TreeNode root, double target) {
        int cloestIndex = root.val;
        while (root != null) {
            double value = Math.abs(root.val - target);
            cloestIndex = Math.abs(cloestIndex - target) > value ? root.val : cloestIndex;
            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return cloestIndex;
    }
}
