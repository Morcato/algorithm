package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Q144_二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  @author shenzixing
 *  @since 2021-01-27
 */
public class Q144 {

    /**
     * 递归解法
     */
    class Recursion {
        public List<Integer> result = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            handle(root);
            return result;
        }

        public void handle(TreeNode root) {

            if (root == null) {
                return;
            }
            result.add(root.val);
            handle(root.left);
            handle(root.right);

        }
    }

    /**
     * 迭代方式前序遍历
     *
     * 首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，所以我们优先将头结点加入Stack，然后打印。
     *
     * 之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
     * 此时你能得到的流程如下:
     *
     */
    class PreOrderIteration {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }


            }
            return result;

        }

    }
}
