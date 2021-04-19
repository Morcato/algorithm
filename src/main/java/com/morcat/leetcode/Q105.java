package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Q105_从前序与中序遍历序列构造二叉树
 *
 *  根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  @author shenzixing
 *  @since 2021-04-19
 */
public class Q105 {

    /**
     * 递归解法
     */
    class Solution {
        public Map<Integer, Integer> inorderIndex = new HashMap();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                inorderIndex.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
            if (preOrderLeft > preOrderRight) {
                return null;
            }
            int rootVal = preorder[preOrderLeft];
            TreeNode root = new TreeNode(rootVal);
            int inorderRootIndex = inorderIndex.get(rootVal);
            root.left = buildTree(preorder, inorder, preOrderLeft + 1, inorderRootIndex - inOrderLeft + preOrderLeft, inOrderLeft, inorderRootIndex - 1);
            root.right = buildTree(preorder, inorder, preOrderLeft + inorderRootIndex - inOrderLeft + 1, preOrderRight, inorderRootIndex + 1, inOrderRight);
            return root;
        }
    }

}
