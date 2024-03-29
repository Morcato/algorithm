package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

/**
 *  Q617_合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 *  @author shenzixing
 *  @since 2021-02-22
 */
public class Q617 {

    /**
     * DFS
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;

    }

    /**
     * 2024.2.12 新做该提的答案,比上述方案耗时更多,内存占用更多.但思路一致,都是dfs
     */
    public TreeNode mergeTreesV2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        int val = 0;
        if(root1 != null){
            val = val + root1.val;
        }
        if(root2 != null){
            val = val + root2.val;
        }
        TreeNode left = mergeTrees(root1 == null?null:root1.left,root2 == null?null:root2.left);
        TreeNode right = mergeTrees(root1==null?null:root1.right,root2 == null?null:root2.right);
        return new TreeNode(val,left,right);
    }

}
