package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *
 * Q124_二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 *
 * @author shenzixing
 * @date 2024/2/18
 */
public class Q124 {

    /**
     * 我的解决方案:采用DFS的方式遍历,但是逻辑写的较为复杂.
     */
    class MySolution {

        Integer max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        public Integer dfs(TreeNode root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            Integer leftValue = dfs(root.left);
            Integer rightValue = dfs(root.right);

            int value = root.val;
            if(leftValue > 0){
                value =  value + leftValue;
            }
            if(rightValue > 0){
                value = value + rightValue;
            }
            max = Math.max(max,value);

            // 左子树与右子树均不为空
            if(leftValue != Integer.MIN_VALUE && rightValue != Integer.MIN_VALUE){
                if(leftValue > rightValue && leftValue > 0){
                    return root.val + leftValue;
                }else if(leftValue < rightValue && rightValue > 0){
                    return root.val + rightValue;
                }
                return root.val;
            }
            // 左子树不为空，右子树为空
            if(leftValue !=  Integer.MIN_VALUE){
                if( leftValue > 0){
                    return root.val + leftValue;
                }
                return root.val;
            }
            // 右子树不为空，左子树为空
            if (rightValue != Integer.MIN_VALUE ){
                if(rightValue > 0){
                    return root.val + rightValue;
                }
                return root.val;
            }
            return root.val;



        }
    }

    /**
     * 同样的DFS,但逻辑更简单
     */
    class ExcellentSolution {

        Integer max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        public Integer dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Integer leftValue = Math.max(dfs(root.left),0);
            Integer rightValue = Math.max(dfs(root.right),0);

            int value = root.val+leftValue+rightValue;
            max = Math.max(max,value);

            return root.val+Math.max(leftValue,rightValue);

        }
    }

}
