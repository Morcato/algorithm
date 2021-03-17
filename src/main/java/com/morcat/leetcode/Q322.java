package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Q322_零钱兑换
 *
 *  @author shenzixing
 *  @since 2021-03-17
 */
public class Q322 {

    /**
     * 暴力递归求解,会超时
     */
    class ClassicSolution {

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {


                int subProblem = coinChange(coins, amount - coin);
                if (subProblem == -1) {
                    continue;
                }
                result = Math.min(result, subProblem + 1);
            }
            if (result == Integer.MAX_VALUE) {
                return -1;
            } else {
                return result;
            }
        }

    }

    /**
     * 使用备忘录优化,暴力解法
     */
    class MemorySolution {

        Map<Integer, Integer> memory = new HashMap<>();

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                memory.put(amount, 0);
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem;
                if (memory.containsKey(amount - coin)) {
                    subProblem = memory.get(amount - coin);
                } else {
                    subProblem = coinChange(coins, amount - coin);
                }

                if (subProblem == -1) {
                    continue;
                }
                result = Math.min(result, subProblem + 1);
            }
            if (result == Integer.MAX_VALUE) {
                memory.put(amount, -1);
                return -1;
            } else {
                memory.put(amount, result);
                return result;
            }
        }

    }

}
