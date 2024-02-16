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

    /**
     * 2024.2.17 当年字节二面时未做出,如今用了3H终于解了出来!
     * 需要注意的点是集散前序遍历的右子树第一个数组下标时需要用inRootIndex - inStart + 1 + preStart!
     */
    class MySolution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

            TreeNode node = new TreeNode(preorder[preStart]);

            int inRootIndex = getIndex(inorder, preorder[preStart]);

            // 有左子树
            if(inRootIndex > inStart){
                int leftInStart = inStart;
                int leftInEnd = inRootIndex - 1;
                int leftPreStart = preStart + 1;
                int leftPreEnd = preStart + inRootIndex - inStart ;
                node.left = build(preorder, inorder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
            }

            // 有右子树
            if(inRootIndex < inEnd){
                int rightInStart = inRootIndex + 1 ;
                int rightInEnd = inEnd;
                int rightPreStart = inRootIndex - inStart + 1 + preStart;
                int rightPreEnd = preEnd;
                node.right = build(preorder, inorder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
            }

            return node;
        }

        public int getIndex(int[] order, int val) {
            for (int i = 0; i < order.length; i++) {
                if (order[i] == val) {
                    return i;
                }
            }
            return -1;
        }
    }

}
