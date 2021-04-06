package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Q46_全排列
 *
 *  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 *  @author shenzixing
 *  @since 2021-04-06
 */
public class Q46 {

    /**
     * 回溯算法
     * path 保存了路径
     * used表示是否使用过该数字
     *
     * 相比dfs多了回溯
     * 参考:https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     */
    class RecallSolution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            dfs(new ArrayList(), nums, used);
            return result;
        }

        public void dfs(List<Integer> path, int[] nums, boolean[] used) {
            if (path.size() == nums.length) {
                result.add(new ArrayList(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(path, nums, used);

                    // 回溯
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

}
