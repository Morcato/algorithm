package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Q78_子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 *  @author shenzixing
 *  @since 2021-05-03
 */
public class Q78 {

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 回朔法
     */
    public List<List<Integer>> subsets(int[] nums) {

        dfs(0, nums, new ArrayList());
        return result;
    }

    public void dfs(int index, int[] nums, List<Integer> path) {
        result.add(new ArrayList(path));
        if (path.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }

}
