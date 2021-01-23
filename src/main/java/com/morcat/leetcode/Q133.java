package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Q133_路径总和 II
 *
 *
 *
 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 *
 *  @author shenzixing
 *  @since 2021-01-22
 */
public class Q133 {

    /**
     * 递归解法(深度优先搜索)
     * 效率很低,需要不停创建list
     */
    class Recursion {


        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            path(root, targetSum, 0, new ArrayList());
            return result;
        }

        public void path(TreeNode root, int targetSum, int sum, List<Integer> route) {

            if (root == null) {
                return;
            }

            List<Integer> list = new ArrayList<>(route);
            list.add(root.val);

            if (root.left == null && root.right == null) {
                if (root.val + sum == targetSum) {
                    result.add(list);
                }
                return;
            }

            path(root.left, targetSum, root.val + sum, list);
            path(root.right, targetSum, root.val + sum, list);

        }

    }

    /**
     * 递归解法+回溯(深度优先搜索)
     * 使用了回溯的方式优化了上面不停创建list的方式.提高效率
     */
    class Recursion_Recall {
        List<List<Integer>> result = new ArrayList();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> route = new ArrayList();

            path(root, targetSum, 0, route);
            return result;
        }

        public void path(TreeNode root, int targetSum, int sum, List<Integer> route) {

            if (root == null) {
                return;
            }

            route.add(root.val);

            if (root.left == null && root.right == null) {
                if (root.val + sum == targetSum) {
                    result.add(new ArrayList(route));
                }
                // 回溯
                route.remove(route.size() - 1);
                return;
            }

            path(root.left, targetSum, root.val + sum, route);
            path(root.right, targetSum, root.val + sum, route);
            // 回溯
            route.remove(route.size() - 1);
        }
    }
}
