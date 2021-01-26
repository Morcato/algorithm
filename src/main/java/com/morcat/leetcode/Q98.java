package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Q98_验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *  @author shenzixing
 *  @since 2021-01-26
 */
public class Q98 {

    /**
     * 我的解法
     * 核心思路: 二叉搜索树的中序遍历的结果是一个有序数组.先遍历,再判断出数组是否有序.
     */
    class MySolution{

        public List<Integer> list = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {

            handle(root);

            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>=list.get(i+1)){
                    return false;
                }
            }
            return true;

        }

        public void handle(TreeNode root){

            if(root==null){
                return;
            }
            handle(root.left);
            list.add(root.val);
            handle(root.right);

        }
    }


    /**
     * 优秀解法,思路一致,使用了pre 在遍历中就开始计算.
     */
    class ExcellentSolution {

        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 访问左子树
            if (!isValidBST(root.left)) {
                return false;
            }
            // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            // 访问右子树
            return isValidBST(root.right);
        }
    }

}
