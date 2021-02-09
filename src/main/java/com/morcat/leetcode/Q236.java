package com.morcat.leetcode;

import com.morcat.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Q236_二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  @author shenzixing
 *  @since 2021-02-09
 */
public class Q236 {

    /**
     * 我的解决方式,DFS遍历所有节点,保存p,q的路径,最后再对比.
     * 效率比较低
     */
    class MySolution {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q, new ArrayList());
            TreeNode result = null;
            for (int i = 0; i < pList.size(); i++) {
                if (i >= qList.size()) {
                    break;
                }
                if (pList.get(i).equals(qList.get(i))) {
                    result = pList.get(i);
                } else {
                    break;
                }
            }
            return result;
        }

        public void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> temp) {
            if (root == null) {
                return;
            }

            temp.add(root);
            if (root.val == p.val) {
                pList.addAll(temp);
            }
            if (root.val == q.val) {
                qList.addAll(temp);
            }

            dfs(root.left, p, q, temp);
            dfs(root.right, p, q, temp);
            temp.remove(temp.size() - 1);

        }
    }

    /**
     * 使用了后序遍历的方式
     *
     * 当遇到节点 pp 或 qq 时返回。从底至顶回溯，当节点 p, qp,q 在节点 rootroot 的异侧时，节点 rootroot 即为最近公共祖先，则向上返回 rootroot 。
     *
     */
    class ExcellentSolution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;


        }
    }


}
